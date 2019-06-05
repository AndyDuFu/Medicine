package com.medicine.batch.install.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.collect.Lists;
import com.medicine.batch.install.enums.ChMedEnum;
import com.medicine.batch.install.enums.DiagnosisEnum;
import com.medicine.batch.install.enums.OtherEnum;
import com.medicine.batch.install.enums.PatientEnum;
import com.medicine.batch.install.enums.WestMedEnum;
import com.medicine.batch.install.thread.MultiThreadInstallVisitRecords;
import com.medicine.batch.install.utils.ExcelUtil;
import com.medicine.batch.install.utils.FileUploadUtil;
import com.medicine.domain.Patient;
import com.medicine.domain.attiendRecode.Image;
import com.medicine.domain.attiendRecode.WesternMedicine;
import com.medicine.domain.dto.PatientDTO;
import com.medicine.domain.from.VisitRecordForm;
import com.medicine.domain.from.dome.DiagnosisAndtreatmentFrom;
import com.medicine.domain.from.dome.DiagnosisOfWeFrom;
import com.medicine.domain.from.dome.DiagnosisOfZhFrom;
import com.medicine.domain.from.dome.MedicineFrom;
import com.medicine.domain.from.dome.OrtherFrom;
import com.medicine.domain.from.dome.WesternMedicineFrom;
import com.medicine.service.PatientService;
import com.medicine.service.VisitRecordService;

/**
 * @author FuDu
 * @date 2019-03-14
 * @desc 该类主要用于批量导入病患以及就诊记录
 */
@RestController
@RequestMapping("/batch/install")
@Slf4j
public class BatchInstallRecords {
	@Resource
	private FileUploadUtil upload;
	@Resource
	private ExcelUtil excelUtil;
	@Resource
	private PatientService patientService;
	@Resource
	private VisitRecordService visitRecordService;
	
	/**
	 * @param attach 上传的 xls 文件
	 * @return 插入信息
	 * @desc 上传 excle.xls 文件并批量导入病患以及就诊信息
	 * 	注意 patient 信息没有采用多线程的方式，因为可能一个
	 *  病人有多条就诊记录，如果拆分记录再多线程插入的话，很可
	 *  能造成数据不匹配；即可能有重复的病人信息和就诊记录，要
	 *  避免这种情况就必须保证插入后返回的用户信息是一个整体
	 */
	@PostMapping("/patient")
	public Map<String, Object> batchInstalPatientsAndVisitRecords(@RequestParam("attach")MultipartFile attach) {
		Map<String, Object> result = new HashMap<String, Object>();
		long start = System.currentTimeMillis();
		// 1.上传文件
		String filePath = upload.uploadFile(attach);
		// 2. 初始化 excel 处理对象
		excelUtil.init(filePath);
		// 2.读取 CSV 文件, 解析出病患信息
		List<Patient> currentPatients = parseXlsToGetPatients(excelUtil);
		// 3.取出所有已存在的病患信息
		List<PatientDTO>  originPatients = patientService.findAll();
		// 4.处理解析出的病患信息和已存在的病患信息
		Map<String, List<Patient>> handleRecords = handlePatients(currentPatients, originPatients);
		// 5.批量插入病患信息, 只插入数据库不存在的记录
		List<Patient> targetPatients = patientService.batchInstall(handleRecords.get("current"));
		// 6.读取 CSV 文件, 解析出就诊信息
		List<VisitRecordForm> originVisitRecordForms = parseXlsToGetVisitRecordForm(excelUtil);
		// 7.将插入后的记录和数据库查出的记录合并
		List<Patient> finalPatients = mergePatients(targetPatients, handleRecords.get("origin"));
		// 8.关联插入后的病患信息和就诊信息
		List<VisitRecordForm> targetVisitRecordForms = relatePatientAndVisitRecordForm(finalPatients, originVisitRecordForms);
		// 9.多线程批量插入就诊信息
		multiThreadBachInstallVisitRecordForms(targetVisitRecordForms);
		// 10.删除上传文件
		excelUtil.removeFile(filePath);
		// 11.返回插入病患和就诊信息的记录数
		long end = System.currentTimeMillis();
		result.put("inserted patients", targetPatients.size());
		result.put("inserted visitRecords", targetVisitRecordForms.size());
		result.put("spend time", ((end - start)/1000) + " s");
		
		log.info("batch installed patients: " + targetPatients.size() + ", visitRecords: " 
					+ targetVisitRecordForms.size() + ", spend time: " + ((end - start)/1000) + " s");
		return result;
	}
	
	// 合并插入数据库后的记录和数据库已经存在的记录
	public List<Patient> mergePatients(List<Patient> targetPatients, List<Patient> originPatients) {
		if(null == originPatients) {
			return targetPatients;
		}
		targetPatients.addAll(originPatients);
		return targetPatients;
	}
	
	// 将已经存在的记录提取出来，将需要新插入的记录提取出来
	public Map<String, List<Patient>> handlePatients(List<Patient> patients, List<PatientDTO> patientDTOs) {
		Map<String, List<Patient>> result = new HashMap<>();
		// 如果数据库没有病患记录，就返回解析出的所有记录
		if(patientDTOs.isEmpty()) {
			// 解析出的
			result.put("current", patients); 
			// 数据库的
			result.put("origin", null); 
		} else {
			// 如果数据库已经有病患记录，就提取出来
			
			// currentPatients 表示当前解析出的记录
			List<Patient> currentPatients = new ArrayList<>();
			currentPatients.addAll(patients);
			// originPatiens 表示数据库已存在的记录
			List<Patient> originPatiens = new ArrayList<>();
			for(Patient patient : patients) {
				for(PatientDTO patientDTO : patientDTOs) {
					if((patient.getName().trim() + patient.getPhone().trim()).equals(patientDTO.getName().trim() + patientDTO.getPhone().trim())) {
						patient.setId(patientDTO.getId());
						// 把已经存在的记录保存到新的集合
						originPatiens.add(patient);
						// 如果数据库已经有记录了，将从解析出的记录中去掉
						currentPatients.remove(patient);
					}
				}
			}
			result.put("current", currentPatients);
			result.put("origin", originPatiens);	
		}
		return result;
	}
	
	// 解析病患信息
	public List<Patient> parseXlsToGetPatients(ExcelUtil excelUtil) {
		Set<Patient> patients = new HashSet<Patient>();
		Map<String, Integer> head = excelUtil.getHeader();
		List<List<String>> rows = excelUtil.getRows();
		for(List<String> row : rows) {
			Patient patient = new Patient();
			patient.setName(row.get(head.get(PatientEnum.NAME.desc())));
			patient.setSex(row.get(head.get(PatientEnum.SEX.desc())));
			patient.setAge(Integer.parseInt(row.get(head.get(PatientEnum.AGE.desc()))));
			patient.setPhone(row.get(head.get(PatientEnum.PHONE.desc())));
			patient.setAddress(row.get(head.get(PatientEnum.ADDRESS.desc())));
			patient.setBirthplace(row.get(head.get(PatientEnum.BIRTHPLACE.desc())));
			patient.setZipCode(row.get(head.get(PatientEnum.ZIPCODE.desc())));
			patient.setMarriage(Integer.parseInt(row.get(head.get(PatientEnum.MARRIAGE.desc()))));
			patient.setCitizenship(row.get(head.get(PatientEnum.CITIZENSHIP.desc())));
			patient.setProfession(row.get(head.get(PatientEnum.PROFESSION.desc())));
			patient.setEthnic(row.get(head.get(PatientEnum.ETHNIC.desc())));
			patient.setWeight(Double.parseDouble(row.get(head.get(PatientEnum.WEIGHT.desc()))));
			patients.add(patient);		
		}
		return new ArrayList<Patient>(patients);
	}
	
	// 解析出就诊信息
	public List<VisitRecordForm> parseXlsToGetVisitRecordForm(ExcelUtil excelUtil) {
		List<VisitRecordForm> visitRecordForms = new ArrayList<VisitRecordForm>();
		Map<String, Integer> head = excelUtil.getHeader();
		List<List<String>> rows = excelUtil.getRows();
		for(List<String> row : rows) {
			VisitRecordForm visitRecordForm = new VisitRecordForm();
			// 解析 诊断治疗 项
			DiagnosisAndtreatmentFrom diagnosisAndtreatment = new DiagnosisAndtreatmentFrom();
			diagnosisAndtreatment.setMedicine(parseStringToMedicineFrom(row.get(head.get(DiagnosisEnum.MEDICINE.desc()))));
			diagnosisAndtreatment.setZyjb(parseStringToList(row.get(head.get(DiagnosisEnum.ZYJB.desc()))));
			diagnosisAndtreatment.setXyjb(parseStringToList(row.get(head.get(DiagnosisEnum.XYJB.desc()))));
			diagnosisAndtreatment.setZyzh(parseStringToList(row.get(head.get(DiagnosisEnum.ZYZH.desc()))));
			diagnosisAndtreatment.setZzzf(parseStringToList(row.get(head.get(DiagnosisEnum.ZZZF.desc()))));
			diagnosisAndtreatment.setZfm(row.get(head.get(DiagnosisEnum.ZFM.desc())));
			diagnosisAndtreatment.setType(row.get(head.get(DiagnosisEnum.TYPE.desc())));
			diagnosisAndtreatment.setNumber(row.get(head.get(DiagnosisEnum.NUMBER.desc())));
			diagnosisAndtreatment.setDoctor(row.get(head.get(DiagnosisEnum.DOCTOR.desc())));
			diagnosisAndtreatment.setMedicineC(row.get(head.get(DiagnosisEnum.MEDICINEC.desc())));
			diagnosisAndtreatment.setMedicineW(row.get(head.get(DiagnosisEnum.MEDICINEW.desc())));
			diagnosisAndtreatment.setOrther(row.get(head.get(DiagnosisEnum.OTHER.desc())));
			
			// 解析 西医检查(批量导入时，无法添加图片以及图片信息，该项没有意义，考虑去掉)
			DiagnosisOfWeFrom diagnosisOfWe = new DiagnosisOfWeFrom();
			diagnosisOfWe.setTigejiancha(row.get(head.get(WestMedEnum.BODYCHECK.desc())));
			// 批量导入时，这些图片和图片信息无法导入，我们构造一个空对象替代
			List<WesternMedicine> westernMedicines = generateWesternMedicines();
			diagnosisOfWe.setWesternMedicines(westernMedicines);
			
			// 解析 中医四诊
			DiagnosisOfZhFrom diagnosisOfZh = new DiagnosisOfZhFrom();
			diagnosisOfZh.setZusu(row.get(head.get(ChMedEnum.ZUSU.desc())));
			diagnosisOfZh.setXianbingshi(row.get(head.get(ChMedEnum.XIANBINGSHI.desc())));
			diagnosisOfZh.setJiwangshi(row.get(head.get(ChMedEnum.JIWANGSHI.desc())));
			diagnosisOfZh.setGuomingshi(row.get(head.get(ChMedEnum.GUOMINGSHI.desc())));
			diagnosisOfZh.setHunyushi(row.get(head.get(ChMedEnum.HUNYUSHI.desc())));
			diagnosisOfZh.setGerenshi(row.get(head.get(ChMedEnum.GERENSHI.desc())));
			diagnosisOfZh.setJiazhushi(row.get(head.get(ChMedEnum.JIAZHUSHI.desc())));
			diagnosisOfZh.setSehz(row.get(head.get(ChMedEnum.SEHZ.desc())));
			diagnosisOfZh.setShensexingtai(row.get(head.get(ChMedEnum.SHENSEXINGTAI.desc())));
			diagnosisOfZh.setXiongfu(row.get(head.get(ChMedEnum.XIONGFU.desc())));
			diagnosisOfZh.setYaobeishizhizhuajia(row.get(head.get(ChMedEnum.YAOBEISHIZHIZHUAJIA.desc())));
			diagnosisOfZh.setPifimaofa(row.get(head.get(ChMedEnum.PIFIMAOFA.desc())));
			diagnosisOfZh.setToumainwuguanjinxiang(row.get(head.get(ChMedEnum.TOUMAINWUGUANJINXIANG.desc())));
			diagnosisOfZh.setQinahoueryinjipaixiewu(row.get(head.get(ChMedEnum.QINAHOUERYINJIPAIXIEWU.desc())));
			
			// 批量导入的时候无法添加舌诊图片信息，我们构建一个空的对象替代
			WesternMedicineFrom westernMedicineFrom = generateWesternMedicineFrom();
			diagnosisOfZh.setShezhenimg(westernMedicineFrom);
			diagnosisOfZh.setMaizhen(row.get(head.get(ChMedEnum.MAIZHEN.desc())));
			diagnosisOfZh.setWenzhen(row.get(head.get(ChMedEnum.WENZHEN.desc())));
			diagnosisOfZh.setQita(row.get(head.get(ChMedEnum.QITA.desc())));
			diagnosisOfZh.setZhenzhuang(parseStringToList(row.get(head.get(ChMedEnum.ZHENZHUANG.desc()))));
			diagnosisOfZh.setShezheng(parseStringToList(row.get(head.get(ChMedEnum.SHEZHENG.desc()))));
			diagnosisOfZh.setMaizhenSel(parseStringToList(row.get(head.get(ChMedEnum.MAIZHENSEL.desc()))));
			
			// 解析 其他信息
			OrtherFrom ortherFrom = new OrtherFrom();
			ortherFrom.setZylxpj(row.get(head.get(OtherEnum.ZYLXPJ.desc())));
			ortherFrom.setXylxpj(row.get(head.get(OtherEnum.XYLXPJ.desc())));
			ortherFrom.setDate(row.get(head.get(OtherEnum.DATE.desc())));
			ortherFrom.setHuifangren(row.get(head.get(OtherEnum.HUIFANGREN.desc())));
			ortherFrom.setHuifangneirong(row.get(head.get(OtherEnum.HUIFANGNEIRONG.desc())));
			ortherFrom.setQita(row.get(head.get(OtherEnum.QITA.desc())));
			ortherFrom.setLsdy(row.get(head.get(OtherEnum.LSDY.desc())));
			ortherFrom.setGrxd(row.get(head.get(OtherEnum.GRXD.desc())));
			ortherFrom.setZjdp(row.get(head.get(OtherEnum.ZJDP.desc())));
			
			// 整合数据结构
			visitRecordForm.setDiagnosisAndtreatment(diagnosisAndtreatment);
			visitRecordForm.setDiagnosisOfWe(diagnosisOfWe);
			visitRecordForm.setDiagnosisOfZh(diagnosisOfZh);
			visitRecordForm.setOrther(ortherFrom);
			// 添加关联条件, 用于数据整合
			String condition = row.get(head.get(PatientEnum.NAME.desc())) + row.get(head.get(PatientEnum.PHONE.desc()));
			visitRecordForm.setPatientNameAndPhone(condition);
			visitRecordForms.add(visitRecordForm);
		}
		return visitRecordForms;
	}
	
	// 关联病患信息和就诊信息(设置 id)
	public List<VisitRecordForm> relatePatientAndVisitRecordForm(List<Patient> patients, List<VisitRecordForm> visitRecordForms) {
		List<VisitRecordForm> targetVisitRecordForms = new ArrayList<VisitRecordForm>();
		for(Patient patient : patients) {
			for(VisitRecordForm visitRecordForm : visitRecordForms) {
				// 如果条件符合，就关联病患和就诊信息记录
				if((patient.getName() + patient.getPhone()).equals(visitRecordForm.getPatientNameAndPhone())) {
					visitRecordForm.setId(patient.getId());
					targetVisitRecordForms.add(visitRecordForm);
				}
			}
		}
		return targetVisitRecordForms;
	}
	
	// 将字符串解析成 List 集合
	public List<String> parseStringToList(String str) {
		List<String> list = new ArrayList<String>();
		if(!StringUtils.isEmpty(str)) {
			String[] strs = str.split(",");
			return Arrays.asList(strs);
		} 
		return list;
	}
	
	// 将字符串解析成 MedicineFrom 对象集合
	public List<MedicineFrom> parseStringToMedicineFrom(String str) {
		List<MedicineFrom> list = new ArrayList<MedicineFrom>();
		if(!StringUtils.isEmpty(str)) {
			String[] strs = str.split(";");
			for(int i = 0; i < strs.length; i++) {
				String[] mfs = strs[i].split(",");
				MedicineFrom medicineFrom = new MedicineFrom();
				medicineFrom.setName(mfs[0]);
				medicineFrom.setLiang(mfs[1]);
				medicineFrom.setZhuyong(mfs[2]);
				medicineFrom.setYongfa(mfs[3]);
				list.add(medicineFrom);
			}
		}
		return list;
	}
	
	// 将字符串解析成 WesternMedicine 对象集合 
	public List<WesternMedicine> parseWesternMedicine(String str) {
		List<WesternMedicine> list = new ArrayList<WesternMedicine>();
		if(!StringUtils.isEmpty(str)) {
			String[] strs = str.split(";");
			for(int i = 0; i < strs.length; i++) {
				String[] wms = strs[i].split(",");
				WesternMedicine westernMedicine = new WesternMedicine();
				westernMedicine.setText(wms[0]);
				westernMedicine.setName(wms[1]);
				list.add(westernMedicine);
			}
		}
		return list;
	}
	
	// 构造一组空的 WesternMedicine 对象
	public List<WesternMedicine> generateWesternMedicines() {
		List<WesternMedicine> westernMedicines = new ArrayList<WesternMedicine>();
		List<Image> images = new ArrayList<Image>();
		westernMedicines.add(new WesternMedicine("血常规", "xcg", images)); 
		westernMedicines.add(new WesternMedicine("心电图", "xdt", images)); 
		westernMedicines.add(new WesternMedicine("尿常规", "ncg", images)); 
		westernMedicines.add(new WesternMedicine("CT", "ct", images)); 
		westernMedicines.add(new WesternMedicine("大便常规", "dbcg", images));
		westernMedicines.add(new WesternMedicine("MRI", "mri", images));
		westernMedicines.add(new WesternMedicine("血生化", "xsh", images));
		westernMedicines.add(new WesternMedicine("超声", "cs", images));
		westernMedicines.add(new WesternMedicine("X光片", "x", images));
		westernMedicines.add(new WesternMedicine("其他", "orther", images));
		return westernMedicines;
	}
	
	// 构造一个空的 WesternMedicineFrom 对象
	public WesternMedicineFrom generateWesternMedicineFrom() {
		WesternMedicineFrom westernMedicineFrom = new WesternMedicineFrom();
		List<Image> images = new ArrayList<Image>();
		westernMedicineFrom.setName("sz");
		westernMedicineFrom.setText("望诊-舌诊图片说明");
		westernMedicineFrom.setImg(images);
		return westernMedicineFrom;
	}
	
	// 将就诊记录拆分成 n 集合，并启用 多个个线程批量插入，以提高效率
	public void multiThreadBachInstallVisitRecordForms(List<VisitRecordForm> visitRecordForms) {
		int size = visitRecordForms.size(), maxNumber = 9, minSize = 500;
		// 最多只启用 10 个线程
		if(size > minSize) {
			int partNumber = size / maxNumber;
			List<List<VisitRecordForm>> visitRecords = Lists.partition(visitRecordForms, partNumber);
			for(int i = 0; i < visitRecords.size(); i++) {
				MultiThreadInstallVisitRecords multiThread = new MultiThreadInstallVisitRecords(visitRecordService, visitRecords.get(i));
				new Thread(multiThread).start();
			}
		} else {
			visitRecordService.batchInstall(visitRecordForms);
		}
	}
}

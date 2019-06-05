package com.medicine.service.impl;

import com.medicine.domain.Patient;
import com.medicine.domain.VisitRecord;
import com.medicine.domain.attiendRecode.*;
import com.medicine.domain.converter.VisitRcodeToVisitRecordDTOConverter;
import com.medicine.domain.dto.PatientRecodDTO;
import com.medicine.domain.dto.VisitRecordDTO;
import com.medicine.domain.dto.YiAnReCodDTO;
import com.medicine.domain.dto.attiendRecode.DataDTO;
import com.medicine.domain.dto.attiendRecode.UserInfoDTO;
import com.medicine.domain.from.VisitRecordForm;
import com.medicine.domain.from.YiAnForm;
import com.medicine.domain.from.dome.DiagnosisAndtreatmentFrom;
import com.medicine.domain.from.dome.DiagnosisOfWeFrom;
import com.medicine.domain.from.dome.DiagnosisOfZhFrom;
import com.medicine.domain.from.dome.OrtherFrom;
import com.medicine.domain.mapper.VisitRecordMapper;
import com.medicine.domain.queryFrom.YanQueryFrom;
import com.medicine.domain.repository.VisitRecordRepository;
import com.medicine.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@Transactional
public class VisitRecordServiceImpl implements VisitRecordService {

    @Autowired
    private VisitRecordRepository visitRecordRepository;
    @Autowired
    private PatientService patientService;
    @Autowired
    private VisitRecordMapper visitRecordMapper;

    /**
     * 保存前端传过来的form对象
     * 看起来很复杂，其实思路很简单的，这里写个注释，方便自己或者收我工作的人看
     * <p>
     * 因为前端传过来的数据很多，json分了很多成，这些数据再不同的表，用外键关联
     * 关联依据都在实体类中体现。
     * <p>
     * 因为有很多数据，包装了很多层json，所以后台接收我也包了很多层
     * 这个方法要做的就是，把不同的数据，放到相应的实体类中去，然后保存
     * 因为用jpa 把关联关系都映射好了的，所以它会把相应的关系的表都添加了，所以
     * 只用保存父类，其它它自己完成
     *
     * @param visitRecordForm
     * @return
     */
    @Override
    public VisitRecord save(VisitRecordForm visitRecordForm) {
        Date date = new Date();
        VisitRecord visitRecord = new VisitRecord();
        visitRecord.setCreateDate(date);
        /** 就诊次数 当前次数+1 **/
        Integer currentTime = visitRecordRepository.
                maxVisitTimes(visitRecordForm.getId());
        Integer time = currentTime == null ? 1 : currentTime + 1;
        visitRecord.setVisitTimes(time);

        Patient patient = patientService.findById(visitRecordForm.getId());
        patient.setTime(time);
        /** 上一次就诊时间 **/
        patient.setEndDate(date);
        /** 首次就诊时间 **/
        if (time.equals(1)) {
            patient.setFirstDate(date);
        }

        /** 修改病人中的就诊时间 **/
        patientService.save(patient);
        
        /** 默认是医案管理 */
        visitRecord.setStatus(1);

        visitRecord.setPatient(new Patient(visitRecordForm.getId()));
        /** 诊断治疗把from 数据转换成实体类 **/
        visitRecord.setDiagnosisAndtreatment(
                DiagnosisAndtreatmentFrom.dFromToD(
                        visitRecordForm.getDiagnosisAndtreatment()
                )
        );
        /** 把中医四诊 提交的from 转换成实体 以下都是， 但是jpa在嵌套第二次的时候
         需要把实体把父级添加到子集里面去 **/
        visitRecord.setDiagnosisOfZh(
                DiagnosisOfZhFrom.dZhFromToD(
                        visitRecordForm.getDiagnosisOfZh()
                )
        );
        /** 西医检查 **/
        visitRecord.setDiagnosisOfWe(
                DiagnosisOfWeFrom.dFromToD(
                        visitRecordForm.getDiagnosisOfWe()
                )
        );

        /** 其他 **/
        visitRecord.setOtherMessage(
                OrtherFrom.ortherFromToOtherMesage(visitRecordForm.getOrther())
        );
        return visitRecordRepository.save(visitRecord);
    }

    @Override
    public PatientRecodDTO findById(Long id) {
        PatientRecodDTO recodDTO = new PatientRecodDTO();
        // 返回信息由两部份组成： 一个是登记记录， 另一个用户信息
        Patient patient = patientService.findById(id);
        UserInfoDTO userInfoDTO = UserInfoDTO.patientToUserInfo(patient);

        List<VisitRecord> visitRecords = visitRecordRepository.findByPatientId(id);
        List<VisitRecordDTO> visitRecordDTOS = VisitRcodeToVisitRecordDTOConverter.convert(visitRecords);
        DataDTO dataDTO = new DataDTO();
        dataDTO.setData(visitRecordDTOS);
        recodDTO.setHistoryData(dataDTO);
        userInfoDTO.setTime(visitRecords.size());
        recodDTO.setInfo(userInfoDTO);
        return recodDTO;
    }

    @Override
    public Page<YiAnReCodDTO> findByNameAndVisitDate(Pageable pageable, String name, String visitDate) {
        List<YiAnReCodDTO> yiAnReCodDTOS = new ArrayList<>();
        // 通过jpa 查询出来。所关联的数据。然后根据关联关系来把它返回成前台的数据
        Page<Patient> patientPage = patientService.findAll(pageable, name, visitDate);
        List<Patient> patients = patientPage.getContent();
        if (patients.size() > 0) {
            patients.forEach(e -> {
                YiAnReCodDTO yiAnReCodDTO = new YiAnReCodDTO();
                List<VisitRecord> visitRecords = e.getVisitRecords();
                VisitRecord visitRecord = null;
                if (visitRecords.size() > 0) {
                    for (VisitRecord record : visitRecords) {
                        if (record.getStatus() != null && record.getStatus().equals(1)) {
                            visitRecord = record;
                            break;
                        }
                    }
                }
                if (visitRecord != null) {
                    BeanUtils.copyProperties(e, yiAnReCodDTO);
                    VisitRecordDTO visitRecordDTO = VisitRcodeToVisitRecordDTOConverter.convert(visitRecord);
                    yiAnReCodDTO.setId(e.getId());
                    yiAnReCodDTO.setVisitId(visitRecord.getId());
                    yiAnReCodDTO.setDiagnosisOfWe(visitRecordDTO.getDiagnosisOfWe());
                    yiAnReCodDTO.setDiagnosisAndtreatment(visitRecordDTO.getDiagnosisAndtreatment());
                    yiAnReCodDTO.setDiagnosisOfZh(visitRecordDTO.getDiagnosisOfZh());
                    yiAnReCodDTO.setOrther(visitRecordDTO.getOrther());
                    yiAnReCodDTO.setDate(e.getFirstDate());
                    yiAnReCodDTO.setVisitTimes(e.getTime());
                    yiAnReCodDTO.setAddress(e.getAddress());
                    yiAnReCodDTOS.add(yiAnReCodDTO);
                }

            });
        }
        return new PageImpl(yiAnReCodDTOS, pageable, patientPage.getTotalElements());
    }

    @Override
    public Long patiendSave(YiAnReCodDTO yiAnReCodDTO) {
        return null;
    }

    @Autowired
    private DiagnosisOfZhService diagnosisOfZhService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private MedicineService medicineService;
    @Autowired
    private WesternMedicineService westernMedicineService;
    @Autowired
    private DiagnosisAndTreatmentService diagnosisAndtreatmentService;

    public void deleteOldData(VisitRecord visit) {

        DiagnosisAndTreatment diagnosisAndtreatment = visit.getDiagnosisAndtreatment();
        diagnosisAndtreatment.setMedicine(null);
        diagnosisAndtreatmentService.save(diagnosisAndtreatment);
        medicineService.deleteByDatId(diagnosisAndtreatment.getId());
        /** 需要删除以前的图片（在添加，或者修改的时候）*/

        DiagnosisOfZh diagnosisOfZh = visit.getDiagnosisOfZh();


        WesternMedicine westernMedicine = diagnosisOfZh.getWesternMedicine();
        /** 这里要复制的原因是，如果多对一关系中， 少的一方如果序列化对象了，那么在多的一方则需要清空 */
//        List<Image> images = westernMedicine.getImg();
        westernMedicine.setImg(null);
        westernMedicineService.save(westernMedicine);

        imageService.deleteByWesternMedicineId(westernMedicine.getId());
        DiagnosisOfWe diagnosisOfWe = visit.getDiagnosisOfWe();
        List<WesternMedicine> westernMedicines = diagnosisOfWe.getWesternMedicines();
        westernMedicines.forEach(e -> {
            e.setImg(null);
            westernMedicineService.save(e);
            imageService.deleteByWesternMedicineId(e.getId());
        });
    }

    @Override
    public void editYianRecode(YiAnForm yiAnForm) {

        Patient patient = patientService.findById(yiAnForm.getId());
        BeanUtils.copyProperties(yiAnForm, patient);

        VisitRecord v = new VisitRecord();
        v.setId(yiAnForm.getVisitId());
        VisitRecord visitRecord = visitRecordRepository.findOne(Example.of(v)).get();

        visitRecord.setPatient(patient);


        VisitRecord v1 = new VisitRecord();
        v1.setId(yiAnForm.getVisitId());

        VisitRecord visit = visitRecordRepository.findOne(Example.of(v1)).get();
        deleteOldData(visit);
        /** 诊断治疗把from 数据转换成实体类 **/
        visitRecord.setDiagnosisAndtreatment(
                DiagnosisAndtreatmentFrom.dFromToD(
                        yiAnForm.getDiagnosisAndtreatment()
                )
        );
        /** 把中医四诊 提交的from 转换成实体 以下都是， 但是jpa在嵌套第二次的时候
         需要把实体把父级添加到子集里面去 */
        visitRecord.setDiagnosisOfZh(
                DiagnosisOfZhFrom.dZhFromToD(
                        yiAnForm.getDiagnosisOfZh()
                )
        );


        /** 西医检查 */
        visitRecord.setDiagnosisOfWe(
                DiagnosisOfWeFrom.dFromToD(
                        yiAnForm.getDiagnosisOfWe()
                )
        );

        /** 其他 */
        visitRecord.setOtherMessage(
                OrtherFrom.ortherFromToOtherMesage(yiAnForm.getOrther())
        );
        visitRecordRepository.save(visitRecord);
    }

    @Override
    public void setYiyan(Long id) {

        VisitRecord v = new VisitRecord();
        v.setId(id);
        VisitRecord visitRecord = visitRecordRepository.findOne(Example.of(v)).get();

        visitRecord.setStatus(1);
        visitRecordRepository.save(visitRecord);
    }

    @Override
    public List<YiAnReCodDTO> findALl(YanQueryFrom yanQueryFrom) {
        List<VisitRecord> visitRecords = visitRecordMapper.findAll(yanQueryFrom);
        List<YiAnReCodDTO> yiAnReCodDTOS = new ArrayList<>();
        visitRecords.forEach(e->{
            Patient p = e.getPatient();
            YiAnReCodDTO yiAnReCodDTO = new YiAnReCodDTO();
            BeanUtils.copyProperties(p, yiAnReCodDTO);
            VisitRecordDTO visitRecordDTO = VisitRcodeToVisitRecordDTOConverter.convert(e);
            yiAnReCodDTO.setVisitId(e.getId());
            yiAnReCodDTO.setDiagnosisOfWe(visitRecordDTO.getDiagnosisOfWe());
            yiAnReCodDTO.setDiagnosisAndtreatment(visitRecordDTO.getDiagnosisAndtreatment());
            yiAnReCodDTO.setDiagnosisOfZh(visitRecordDTO.getDiagnosisOfZh());
            yiAnReCodDTO.setOrther(visitRecordDTO.getOrther());
            yiAnReCodDTO.setDate(p.getFirstDate());
            yiAnReCodDTO.setVisitTimes(p.getTime());
            yiAnReCodDTO.setAddress(p.getAddress());
            yiAnReCodDTOS.add(yiAnReCodDTO);
        });
        return yiAnReCodDTOS;
    }

    // 批量导入就诊信息
	@Override
	public void batchInstall(List<VisitRecordForm> visitRecordForms) {
		for(VisitRecordForm visitRecordForm : visitRecordForms) {
			save(visitRecordForm);
		}
	}
}

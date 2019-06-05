package com.medicine.batch.install.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicine.batch.install.model.Medicine;
import com.medicine.batch.install.model.PatientRecord;
import com.medicine.batch.install.serviceImpl.IBatchExportRecordsService;
import com.medicine.batch.install.serviceImpl.IMedicineRecordsService;
import com.medicine.batch.install.utils.ExcelUtil;
import com.medicine.batch.install.utils.FileDownLoadUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * @author FuDu
 * @date 2019-04-03
 * @desc 用户批量导出所有病人和就诊记录信息
 */
@RestController
@RequestMapping("/batch/export")
@Slf4j
public class BatchExportRecords {
	@Resource
	private IBatchExportRecordsService batchExportRecordsService;
	
	@Resource
	private IMedicineRecordsService medicineRecordsService;
	
	@Resource
	private FileDownLoadUtil downloadUtil;
	
	@Resource
	private ExcelUtil excelUtil;
	
	/**
	 * 下载所有用户的基本信息和就诊记录
	 */
	@GetMapping("/patient")
	public void exportPatientRecords(HttpServletResponse response) {
		//1. 获取所有病患和就诊记录基本信息
		List<PatientRecord> patientRecords = batchExportRecordsService.getPatientRecords();
		//2. 获取所有医药记录
		List<Medicine> medicineRecords = medicineRecordsService.getMedicineRecords();
		//3. 关联病患基本信息和对应的医药记录
		List<PatientRecord> patients = relatedPatientAndMecineRecord(patientRecords, medicineRecords);
		log.info("export patient records size: " + patients.size());
		//4. 生成 xls 文件
		String filePath = excelUtil.writeExcel(patients);
		log.info("download patient record file --> " + filePath);
		//5. 下载到客户端
		downloadUtil.downloadLocal(filePath, response);
	}
	/**
	 * 关联病患基本信息和对应的医药记录
	 * @param patients
	 * @param medicines
	 */
	public List<PatientRecord> relatedPatientAndMecineRecord(List<PatientRecord> patients, List<Medicine> medicines) {
		for(PatientRecord patient : patients) {
			StringBuilder medicineRecord = new StringBuilder();
			for(Medicine medicine : medicines) {
				if(patient.getDmid() == medicine.getDatid()) {
					medicineRecord.append(medicine.toString());
				}
			}
			patient.setMedicine(medicineRecord.toString());
		}
		return patients;
	}
}

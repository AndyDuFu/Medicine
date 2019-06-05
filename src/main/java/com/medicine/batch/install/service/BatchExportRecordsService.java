package com.medicine.batch.install.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medicine.batch.install.model.PatientRecord;
import com.medicine.batch.install.serviceImpl.IBatchExportRecordsService;
import com.medicine.domain.mapper.PatientRecordsMapper;

/**
 * @author FuDu
 * @date 2019-04-03
 * @desc 用户批量导出病患和就诊信息
 */
@Service
@Transactional
public class BatchExportRecordsService implements IBatchExportRecordsService {
	@Resource
	private PatientRecordsMapper patientRecordsMapper;

	@Override
	public List<PatientRecord> getPatientRecords() {
		return patientRecordsMapper.getPatientRecords();
	}

}

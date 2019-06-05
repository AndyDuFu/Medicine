package com.medicine.domain.mapper;

import java.util.List;

import com.medicine.batch.install.model.PatientRecord;

/**
 * @author FuDu
 * @date 2019-04-03
 * @desc 用户批量导出病患和就诊信息
 */
public interface PatientRecordsMapper {
	List<PatientRecord> getPatientRecords();
}

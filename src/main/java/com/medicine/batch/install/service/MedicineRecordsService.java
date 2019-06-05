package com.medicine.batch.install.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medicine.batch.install.model.Medicine;
import com.medicine.batch.install.repository.MedicineRecordsRepository;
import com.medicine.batch.install.serviceImpl.IMedicineRecordsService;

/**
 * @author FuDu
 * @date 2019-04-03
 */
@Service
@Transactional
public class MedicineRecordsService implements IMedicineRecordsService {
	@Resource
	private MedicineRecordsRepository medicineRecordsRepository;

	@Override
	public List<Medicine> getMedicineRecords() {
		return medicineRecordsRepository.getMedicineRecords();
	}

}

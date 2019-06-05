package com.medicine.service.impl;

import com.medicine.domain.attiendRecode.Medicine;
import com.medicine.domain.repository.attiendRecode.MedicineRepository;
import com.medicine.service.MedicineService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineServiceImpl implements MedicineService {
    @Autowired
    MedicineRepository medicineRepository;
    @Override
    public void delete(Medicine medicine) {
        medicineRepository.delete(medicine);
    }

    @Override
    public void deleteById(Long id) {
        medicineRepository.deleteById(id);
    }

    @Override
    public void deleteByDatId(Long id) {
        medicineRepository.deleteByDatId(id);
    }
}

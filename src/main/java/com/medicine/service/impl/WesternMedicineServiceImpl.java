package com.medicine.service.impl;

import com.medicine.domain.attiendRecode.WesternMedicine;
import com.medicine.domain.repository.attiendRecode.WesternMedicineRepository;
import com.medicine.service.WesternMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WesternMedicineServiceImpl implements WesternMedicineService {

    @Autowired
    private WesternMedicineRepository westernMedicineRepository;

    @Override
    public WesternMedicine save(WesternMedicine westernMedicine) {
        return westernMedicineRepository.save(westernMedicine);
    }
}

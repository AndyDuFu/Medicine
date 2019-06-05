package com.medicine.service;

import com.medicine.domain.attiendRecode.Medicine;

public interface MedicineService {
    void delete(Medicine medicine);
    void deleteById(Long id);
    void deleteByDatId(Long id);
}

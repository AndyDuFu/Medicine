package com.medicine.service;

import com.medicine.domain.attiendRecode.Image;

public interface ImageService {
    Image save(Image image);
    void delete(Image image);
    void deleteById(Long id);
    void deleteByWesternMedicineId(Long id);
}

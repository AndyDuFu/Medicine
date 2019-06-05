package com.medicine.service;

import com.medicine.domain.Datum;
import com.medicine.domain.dto.DatumDTO;
import com.medicine.domain.dto.PatientRecodDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DatumService {

    Datum save(Datum datum);

    void delete(Long id);

    List<DatumDTO> findByTitleAndKey(String title, String key);
}

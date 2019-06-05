package com.medicine.service.impl;

import com.medicine.domain.attiendRecode.DiagnosisOfWe;
import com.medicine.domain.repository.attiendRecode.DiagnosisOfWeRepository;
import com.medicine.service.DiagnosisOfWeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiagnosisOfWeServiceImpl implements DiagnosisOfWeService {

    @Autowired
    private DiagnosisOfWeRepository diagnosisOfWeRepository;

    @Override
    public DiagnosisOfWe save(DiagnosisOfWe diagnosisOfWe) {
        return diagnosisOfWeRepository.save(diagnosisOfWe);
    }
}

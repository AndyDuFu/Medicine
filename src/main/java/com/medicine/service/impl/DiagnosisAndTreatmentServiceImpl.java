package com.medicine.service.impl;

import com.medicine.domain.attiendRecode.DiagnosisAndTreatment;
import com.medicine.domain.repository.attiendRecode.DiagnosisAndtreatmentRepository;
import com.medicine.service.DiagnosisAndTreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiagnosisAndTreatmentServiceImpl implements DiagnosisAndTreatmentService {
    @Autowired
    private DiagnosisAndtreatmentRepository diagnosisAndtreatmentRepository;

    @Override
    public DiagnosisAndTreatment save(DiagnosisAndTreatment diagnosisAndtreatment) {
        return diagnosisAndtreatmentRepository.save(diagnosisAndtreatment);
    }
}

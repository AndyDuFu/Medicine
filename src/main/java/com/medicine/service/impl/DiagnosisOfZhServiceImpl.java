package com.medicine.service.impl;

import com.medicine.domain.attiendRecode.DiagnosisOfZh;
import com.medicine.domain.repository.attiendRecode.DiagnosisOfZhRepository;
import com.medicine.service.DiagnosisOfZhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class DiagnosisOfZhServiceImpl implements DiagnosisOfZhService {
    @Autowired
    private DiagnosisOfZhRepository diagnosisOfZhRepository;

    @Override
    public DiagnosisOfZh save(DiagnosisOfZh diagnosisOfZh) {
        return diagnosisOfZhRepository.save(diagnosisOfZh);
    }

    @Override
    public DiagnosisOfZh findById(Long id) {
        DiagnosisOfZh diagnosisOfZh = new DiagnosisOfZh();
        diagnosisOfZh.setId(id);
        return diagnosisOfZhRepository.findOne(Example.of(diagnosisOfZh)).get();
    }
}

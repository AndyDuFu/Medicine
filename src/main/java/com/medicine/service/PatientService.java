package com.medicine.service;

import com.medicine.domain.Patient;
import com.medicine.domain.dto.PatientDTO;
import com.medicine.domain.from.PatientFrom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PatientService {

    Page<PatientDTO> findPatientCriteria(Pageable pageable, String name);

    Patient save(PatientFrom patientFrom);

    Patient findById(Long id);

    Patient save(Patient patient);

    List<Patient> findByPhone(String phone);

    Page<Patient> findAll(Pageable pageable, String name, String visitDate);
    
    // 批量导入病患信息
    List<Patient> batchInstall(List<Patient> patients);
    
    List<PatientDTO> findAll();
    
    void deleteById(long id);
}

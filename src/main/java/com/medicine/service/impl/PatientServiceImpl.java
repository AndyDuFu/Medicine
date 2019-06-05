package com.medicine.service.impl;

import com.medicine.domain.Patient;
import com.medicine.domain.converter.PatientToPatientDTOConverter;
import com.medicine.domain.dto.PatientDTO;
import com.medicine.domain.from.PatientFrom;
import com.medicine.domain.repository.PatientRepository;
import com.medicine.service.PatientService;
import com.medicine.util.DatetimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import java.util.List;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;


    @Override
    public Page<PatientDTO> findPatientCriteria(Pageable pageable, String name) {
        Page<Patient> patients = StringUtils.isEmpty(name)?
                patientRepository.findAll(pageable):patientRepository.findByNameLike("%"+name+"%", pageable);
        List<PatientDTO> PatientDTOS =
                PatientToPatientDTOConverter.converter(patients.getContent());

        return new PageImpl<>(PatientDTOS, pageable, patients.getTotalElements());
    }

    @Override
    public Patient save(PatientFrom patientFrom) {
        return save(PatientFrom.patientFormToPatient(patientFrom));
    }

    @Override
    public Patient findById(Long id) {
        Patient patient = new Patient();
        patient.setId(id);
        return patientRepository.findOne(Example.of(patient)).get();
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> findByPhone(String phone) {
        return patientRepository.findByPhone(phone);
    }

    @Override
    public Page<Patient> findAll(Pageable pageable, String name, String visitDate) {
        if (StringUtils.isEmpty(name) && StringUtils.isEmpty(visitDate)) {
           return patientRepository.findAll(pageable);
        }
        Patient patient = new Patient();
        if (!StringUtils.isEmpty(visitDate)) {
           patient.setVisitTime(DatetimeUtil.parseDate(visitDate));
        }
        if (!StringUtils.isEmpty(name)) {
            patient.setName(name);
        }
        Example<Patient> example = Example.of(patient);
        return patientRepository.findAll(example, pageable);
    }

    // 批量导入病患信息
	@Override
	public List<Patient> batchInstall(List<Patient> patients) {
		return patientRepository.saveAll(patients);
	}

	@Override
	public List<PatientDTO> findAll() {
		List<Patient> patients = patientRepository.findAll();
		List<PatientDTO> dtos = PatientToPatientDTOConverter.converter(patients);
		return dtos;
	}

	@Override
	public void deleteById(long id) {
		patientRepository.deleteById(id);
	}
}

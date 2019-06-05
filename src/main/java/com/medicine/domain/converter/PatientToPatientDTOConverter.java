package com.medicine.domain.converter;

import com.medicine.domain.Patient;
import com.medicine.domain.dto.PatientDTO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class PatientToPatientDTOConverter{

    public static PatientDTO converter(Patient patient) {
       PatientDTO patientDTO = new PatientDTO();
       BeanUtils.copyProperties(patient, patientDTO);
       patientDTO.setDate(patient.getFirstDate());
       patientDTO.setEndDate(patient.getEndDate());
       return patientDTO;
    }

    public static List<PatientDTO> converter(List<Patient> patients) {
        List<PatientDTO> PatientDTOS = new ArrayList<>();
        patients.forEach(patient -> PatientDTOS.add(converter(patient)));
        return PatientDTOS;
    }
}

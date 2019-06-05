package com.medicine.domain.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.medicine.domain.VisitRecord;
import com.medicine.domain.dto.attiendRecode.DiagnosisOfWeDTO;
import com.medicine.domain.dto.attiendRecode.DiagnosisOfZhDTO;
import com.medicine.domain.dto.attiendRecode.diagnosisAndtreatment.DiagnosisAndtreatmentDTO;
import com.medicine.domain.dto.attiendRecode.orther.OrtherDTO;
import com.medicine.util.Date2LongSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class VisitRecordDTO implements Serializable {

    private Long id;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date date;

    private Integer visitTimes;

    private DiagnosisOfZhDTO diagnosisOfZh;

    private DiagnosisOfWeDTO diagnosisOfWe;

    private DiagnosisAndtreatmentDTO diagnosisAndtreatment;

    private OrtherDTO orther;




}

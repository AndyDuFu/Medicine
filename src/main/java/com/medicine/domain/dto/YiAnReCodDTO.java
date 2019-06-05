package com.medicine.domain.dto;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.medicine.domain.dto.attiendRecode.DiagnosisOfWeDTO;
import com.medicine.domain.dto.attiendRecode.DiagnosisOfZhDTO;
import com.medicine.domain.dto.attiendRecode.diagnosisAndtreatment.DiagnosisAndtreatmentDTO;
import com.medicine.domain.dto.attiendRecode.orther.OrtherDTO;
import com.medicine.util.Date2LongSerializer;
import lombok.Data;

import java.util.Date;

@Data
public class YiAnReCodDTO {

    private Long id;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date date;

    private Integer visitTimes;

    private DiagnosisOfZhDTO diagnosisOfZh;

    private DiagnosisOfWeDTO diagnosisOfWe;

    private DiagnosisAndtreatmentDTO diagnosisAndtreatment;

    private OrtherDTO orther;

    private Long cardId;

    private String name;

    private String sex;

    private String phone;

    // 所在城市
    private String city;

    // 所在省
    private String country;

    // 所在区
    private String province;

    // 出生地
    private String birthplace;

    private Date visitTime;

    // 邮编
    private String zipCode;

    // 婚姻 （1已婚 0未婚 3其他）
    private Integer marriage;

    // 国际
    private String citizenship;

    // 职业
    private String profession;

    // 民族
    private String ethnic;

    // 体重
    private Double weight;

    private Integer age ;

    // 记录id
    private Long visitId;

    private String address;



}

package com.medicine.domain.from;

import com.medicine.domain.from.dome.DiagnosisAndtreatmentFrom;
import com.medicine.domain.from.dome.DiagnosisOfWeFrom;
import com.medicine.domain.from.dome.DiagnosisOfZhFrom;
import com.medicine.domain.from.dome.OrtherFrom;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class YiAnForm {

    private Long id;

    @ApiModelProperty(value = "诊断治疗")
    private DiagnosisAndtreatmentFrom diagnosisAndtreatment;

    @ApiModelProperty(value = "西医检查", notes = "其中包含很多常规检查")
    private DiagnosisOfWeFrom diagnosisOfWe;

    @ApiModelProperty(value = "中医四诊")
    private DiagnosisOfZhFrom diagnosisOfZh;

    @ApiModelProperty(value = "其他信息")
    private OrtherFrom orther;

    private String name;

    private String sex;

    private String phone;

    // 出生地
    private String birthplace;

    @Column(name = "visit_time")
    private Date visitTime;

    // 邮编
    @Column(name = "zip_code")
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

    // 身高
    private Double height;


    private Integer age;

    private String address;

    private Integer time;

    private Long visitId;
}

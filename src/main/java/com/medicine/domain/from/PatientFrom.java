package com.medicine.domain.from;

import com.medicine.domain.Patient;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
@ApiModel(value = "病人提交数据")
public class PatientFrom {

    @ApiModelProperty(value = "id", required = false)
    private Long id;

    private String sex;

    private String name;

    private Integer age;

    private String phone;

    @ApiModelProperty(value = "出生地")
    private String birthplace;

    @ApiModelProperty(value = "邮编")
    private String zipCode;

    @ApiModelProperty(value = "婚姻 （1已婚 0未婚 3其他）")
    private Integer marriage;

    @ApiModelProperty(value = "国籍")
    private String citizenship;

    @ApiModelProperty(value = "民族")
    private String profession;

    private String ethnic;

    private Double weight;

    private String address;


    public static Patient patientFormToPatient(PatientFrom patientForm) {
        Patient  patient = new Patient();
        BeanUtils.copyProperties(patientForm, patient);
        patient.setTime(0);
        Date date = new Date();
        patient.setCreateDate(date);
        patient.setVisitTime(patient.getVisitTime()!= null?patient.getVisitTime():date);
        return patient;
    }
}

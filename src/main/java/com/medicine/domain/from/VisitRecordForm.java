package com.medicine.domain.from;

import com.medicine.domain.from.dome.DiagnosisAndtreatmentFrom;
import com.medicine.domain.from.dome.DiagnosisOfWeFrom;
import com.medicine.domain.from.dome.DiagnosisOfZhFrom;
import com.medicine.domain.from.dome.OrtherFrom;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "就诊记录")
public class VisitRecordForm {

    private Long id;

    @ApiModelProperty(value = "诊断治疗")
    private DiagnosisAndtreatmentFrom diagnosisAndtreatment;

    @ApiModelProperty(value = "西医检查", notes = "其中包含很多常规检查")
    private DiagnosisOfWeFrom diagnosisOfWe;

    @ApiModelProperty(value = "中医四诊")
    private DiagnosisOfZhFrom diagnosisOfZh;

    @ApiModelProperty(value = "其他信息")
    private OrtherFrom orther;
    
    // 用于批量导入关联条件
    private String patientNameAndPhone;
}

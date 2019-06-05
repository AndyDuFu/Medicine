package com.medicine.domain.dto.attiendRecode;

import com.medicine.domain.dto.attiendRecode.diagnosisAndtreatment.WesternMedicineDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("西医")
public class DiagnosisOfWeDTO {

    private Long id;

    private String tigejiancha;

    @ApiModelProperty(value = "血常规")
    private WesternMedicineDTO xcg;

    @ApiModelProperty(value = "心电图")
    private WesternMedicineDTO xdt;

    @ApiModelProperty(value = "尿常规")
    private WesternMedicineDTO ncg;

    @ApiModelProperty(value = "CT")
    private WesternMedicineDTO ct;

    @ApiModelProperty(value = "大便常规")
    private WesternMedicineDTO dbcg;

    @ApiModelProperty(value = "MRI")
    private WesternMedicineDTO mri;

    @ApiModelProperty(value = "血生化")
    private WesternMedicineDTO xsh;

    @ApiModelProperty(value = "超声")
    private WesternMedicineDTO cs;

    @ApiModelProperty(value = "X光")
    private WesternMedicineDTO x;

    @ApiModelProperty(value = "其他")
    private WesternMedicineDTO orther;
}

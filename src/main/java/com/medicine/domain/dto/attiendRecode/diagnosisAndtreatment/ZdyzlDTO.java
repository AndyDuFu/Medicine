package com.medicine.domain.dto.attiendRecode.diagnosisAndtreatment;

import lombok.Data;

import java.util.List;

@Data
public class ZdyzlDTO {
    // 中医疾病
    private String zyjb;

    // 西医疾病
    private String xyjb;

    // 中医证候
    private String zyzh;

    // 治则治法
    private String zzzf;
}

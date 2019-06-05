package com.medicine.domain.dto.attiendRecode.diagnosisAndtreatment;

import com.medicine.domain.attiendRecode.Medicine;
import lombok.Data;

import java.util.List;

@Data
public class ZycfDTO {
    // 名称
    private String zfm;

    // 类型
    private String type;

    // 剂数
    private String number;

    // 医师
    private String doctor;



    // 处方详情
    private List<MedicineDTO> medicine;
}

package com.medicine.domain.dto.attiendRecode.diagnosisOfZh;

import lombok.Data;

@Data
public class AskDTO {
    // 主诉
    private String zusu;

    // 现病史
    private String xianbingshi;

    // 既往史
    private String jiwangshi;

    // 过敏史
    private String guomingshi;

    // 婚育史
    private String hunyushi;

    // 个人史
    private String gerenshi;

    // 家族史
    private String jiazhushi;
}

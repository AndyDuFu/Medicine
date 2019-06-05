package com.medicine.domain.dto.attiendRecode.orther;

import lombok.Data;

@Data
public class HuifangjiluDTO {
    // 时间
    private String date;

    // 回访人
    private String huifangren;

    // 内容
    private String huifangneirong;

    // 其他
    private String qita;
}

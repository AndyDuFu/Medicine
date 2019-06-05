package com.medicine.domain.attiendRecode;


import com.medicine.domain.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 其他信息
 */
@Data
@Entity
@Table(name = "other_message")
public class OtherMessage extends BaseEntity {

    // 中医效果评价
    private String zylxpj;

    // 西医效果评价
    private String xylxpj;

    // 时间
    private String date;

    // 回访人
    private String huifangren;

    // 内容
    private String huifangneirong;

    // 其他
    private String qita;

    // 老师答疑
    private String lsdy;

    // 个人心得
    private String grxd;

    // 专家点评
    private String zjdp;

}

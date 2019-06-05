package com.medicine.domain.attiendRecode;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.medicine.domain.BaseEntity;
import lombok.Data;

import javax.persistence.*;


/**
 * 处方详情
 */
@Data
@Entity
public class Medicine extends BaseEntity {

    // 名称
    private String name;

    // 类型
    private String liang;

    // 作用
    private String zhuyong;

    // 用法
    private String yongfa;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "dat_id")
    @JsonSerialize
    private DiagnosisAndTreatment dat;

}

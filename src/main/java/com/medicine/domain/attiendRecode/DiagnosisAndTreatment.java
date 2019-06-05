package com.medicine.domain.attiendRecode;

import com.medicine.domain.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


/**
 * 诊断治疗
 */
@Data
@Entity
@Table(name = "diagnosis_and_treatment")
public class DiagnosisAndTreatment extends BaseEntity {

    // 中医疾病
    private String zyjb;

    // 西医疾病
    private String xyjb;

    // 中医证候
    private String zyzh;

    // 治则治法
    private String zzzf;

    // 名称
    private String zfm;

    // 类型
    private String type;

    // 剂数
    private String number;

    // 医师
    private String doctor;

    // 中成药
    private String medicineC;

    // 西成药
    private String medicineW;

    // 其他
    private String other;

    // 处方详情
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dat")
    private List<Medicine> medicine;

    @Override
    public String toString() {
        return "DiagnosisAndtreatment{" +
                "zyjb='" + zyjb + '\'' +
                ", xyjb='" + xyjb + '\'' +
                ", zyzh='" + zyzh + '\'' +
                ", zzzf='" + zzzf + '\'' +
                ", zfm='" + zfm + '\'' +
                ", type='" + type + '\'' +
                ", number='" + number + '\'' +
                ", doctor='" + doctor + '\'' +
                ", medicineC='" + medicineC + '\'' +
                ", medicineW='" + medicineW + '\'' +
                ", other='" + other + '\'' +
                ", medicine=" + medicine +
                '}';
    }
}

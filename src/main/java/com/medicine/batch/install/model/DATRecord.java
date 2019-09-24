package com.medicine.batch.install.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author: cddufu@cn.ibm.com
 * @date: 2019-09-24
 * @desc: 诊断和治疗模块
 */
@Data
@Entity
@Table(name = "diagnosis_and_treatment")
public class DATRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /* 处方医师 */
    private String doctor;
    /* 中成药 */
    private String medicinec;
    /* 西成药 */
    private String medicinew;
    /* 处方剂数 */
    private String number;
    /* 其他 */
    private String other;
    /* 处方类型 */
    private String type;
    /* 西医疾病 */
    private String xyjb;
    /* 处方名称 */
    private String zfm;
    /* 中医疾病 */
    private String zyjb;
    /* 中医证候 */
    private String zyzh;
    /* 治则治法 */
    private String zzzf;
}

package com.medicine.batch.install.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author: cddufu@cn.ibm.com
 * @date: 2019-09-24
 * @desc: 西医检查模块
 */
@Data
@Entity
@Table(name = "diagnosis_of_we")
public class WMRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /* 体格检查 */
    private String tigejiancha;
}

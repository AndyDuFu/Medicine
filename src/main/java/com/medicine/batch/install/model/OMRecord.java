package com.medicine.batch.install.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author: cddufu@cn.ibm.com
 * @date: 2019-09-24
 * @desc: 其他信息模块
 */
@Data
@Entity
@Table(name = "other_message")
public class OMRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /* 回访时间 */
    private String date;
    /* 个人心得 */
    private String grxd;
    /* 回访内容 */
    private String huifangneirong;
    /* 回访人 */
    private String huifangren;
    /* 老师答疑 */
    private String lsdy;
    /* 其他 */
    private String qita;
    /* 西医疗效评价 */
    private String xylxpj;
    /* 专家点评 */
    private String zjdp;
    /* 中医疗效评价 */
    private String zylxpj;
}

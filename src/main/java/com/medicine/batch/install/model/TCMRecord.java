package com.medicine.batch.install.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author: cddufu@cn.ibm.com
 * @date: 2019-09-24
 * @desc: 中医四诊模块
 */
@Data
@Entity
@Table(name = "diagnosis_of_zh")
public class TCMRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /* 个人史 */
    @Column(name = "gerenshi")
    private String gerenshi;
    /* 过敏史 */
    @Column(name = "guomingshi")
    private String guomingshi;
    /* 婚育史 */
    @Column(name = "hunyushi")
    private String hunyushi;
    /* 家族史 */
    @Column(name = "jiazhushi")
    private String jiazhushi;
    /* 既往史 */
    @Column(name = "jiwangshi")
    private String jiwangshi;
    /* 脉诊 */
    @Column(name = "maizhen")
    private String maizhen;
    /* 脉诊(四诊摘要) */
    // 出现 Table [] contains logical column name [] referenced by multiple physical column ...
    // 去掉 @Column 注解后消失；说明如果符合 hibernate jpa 命名规范的字段，应尽量去掉 @Column 注解
    //@Column(name = "maizhen_sel")
    private String maizhenSel;
    /* 皮肤毛发 */
    @Column(name = "pifimaofa")
    private String pifimaofa;
    /* 前后二阴及排泄物 */
    @Column(name = "qinahoueryinjipaixiewu")
    private String qinahoueryinjipaixiewu;
    /* 其它 */
    @Column(name = "qita")
    private String qita;
    /* 舌诊 */
    @Column(name = "sehz")
    private String sehz;
    /* 神色形态 */
    @Column(name = "shensexingtai")
    private String shensexingtai;
    /* 舌诊(四诊摘要) */
    @Column(name = "shezheng")
    private String shezheng;
    /* 头面五官颈项 */
    @Column(name = "toumainwuguanjinxiang")
    private String toumainwuguanjinxiang;
    /* 闻诊 */
    @Column(name = "wenzhen")
    private String wenzhen;
    /* 现病史 */
    @Column(name = "xianbingshi")
    private String xianbingshi;
    /* 胸腹 */
    @Column(name = "xiongfu")
    private String xiongfu;
    /* 腰背十指爪甲 */
    @Column(name = "yaobeishizhizhuajia")
    private String yaobeishizhizhuajia;
    /* 症状(四诊摘要) */
    @Column(name = "zhenzhuang")
    private String zhenzhuang;
    /* 主诉 */
    @Column(name = "zusu")
    private String zusu;
    /* 舌诊图片id，必须传递原来的已经有的id，否则会报错；如果不知道，就传递 0 */
    @Column(name = "shezhenimg_id")
    private Long shezhenimgId;
}

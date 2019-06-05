package com.medicine.domain.attiendRecode;

import com.medicine.domain.BaseEntity;
import lombok.Data;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;

/**
 *  中医四诊
 */
@Data
@Entity
@Table(name = "diagnosis_of_zh")
public class DiagnosisOfZh extends BaseEntity {

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

    // 舌诊
    private String sehz;

    // 神色形态
    private String shensexingtai;

    // 胸腹
    private String xiongfu;

    // 腰背四肢爪甲
    private String yaobeishizhizhuajia;

    // 皮肤毛发
    private String pifimaofa;

    // 头面五官颈项
    private String toumainwuguanjinxiang;

    // 前后二阴及
    private String qinahoueryinjipaixiewu;

    // 舌诊图片
    @JoinColumn(name = "shezhenimg_id")
    @OneToOne(cascade = CascadeType.ALL)
    private WesternMedicine westernMedicine;

    // 脉诊
    private String maizhen;

    // 闻诊
    private String wenzhen;

    // 其他
    private String qita;

    // 症状
    private String zhenzhuang;

    // 舌诊
    private String shezheng;

    // 脉诊外键
    private String maizhenSel;

}

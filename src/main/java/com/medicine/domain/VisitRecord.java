package com.medicine.domain;

import com.medicine.domain.attiendRecode.*;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class VisitRecord extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "p_id")
    private Patient patient;

    private Date createDate;

    private Integer visitTimes;

    // 诊断治疗
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diagnosis_treatment_id")
    private DiagnosisAndTreatment diagnosisAndtreatment;

    // 中医四诊
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diagnosis_zh_id")
    private DiagnosisOfZh diagnosisOfZh;

    // 西医检查
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diagnosis_we_id")
    private DiagnosisOfWe diagnosisOfWe;

    // 其他
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "other_id")
    private OtherMessage otherMessage;

    // 0：表示不是医案管理 1：表示是
    private Integer status;

    @Override
    public String toString() {
        return "VisitRecord{" +
                "createDate=" + createDate +
                ", diagnosisAndtreatment=" + diagnosisAndtreatment +
                ", diagnosisOfZh=" + diagnosisOfZh +
                ", diagnosisOfWe=" + diagnosisOfWe +
                ", otherMessage=" + otherMessage +
                '}';
    }
}

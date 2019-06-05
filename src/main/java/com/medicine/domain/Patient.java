package com.medicine.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.medicine.util.Date2LongSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 病人
 */
@Data
@Entity
@EqualsAndHashCode(callSuper=false)
public class Patient extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Long cardId;

    private String name;

    private String sex;

    private String phone;

    // 出生地
    private String birthplace;

    @Column(name = "visit_time")
    private Date visitTime;

    // 邮编
    @Column(name = "zip_code")
    private String zipCode;

    // 婚姻 （1已婚 0未婚 3其他）
    private Integer marriage;

    // 国际
    private String citizenship;

    // 职业
    private String profession;

    // 民族
    private String ethnic;

    // 体重
    private Double weight;

    // 身高
    private Double height;

    @Column(name = "create_date")
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createDate;

    @Column(name = "update_date")
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateDate;

    private Integer age;

    private String address;

    private Integer time;

    /** 第一次就诊时间 **/
    @Column(name = "first_date")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date firstDate;

    /** 上一次就诊时间 **/
    @Column(name = "end_date")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private List<VisitRecord> visitRecords;

    public Patient() {
    }

    public Patient(Long id) {
        super.setId(id);
    }
}

package com.medicine.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
public class Dictionary extends BaseEntity {

    @Column(name = "sys_type")
    private String sysType;

    private String name;
}

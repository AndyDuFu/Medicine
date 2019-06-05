package com.medicine.domain.menu;

import com.medicine.domain.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "prescription")
public class Prescription extends BaseEntity{
    // 方剂id
    private Long menuId;
    // 名称
    private String name;
    // 用量
    private String yl;
    // 作用
    private String zy;
    // 用法
    private String yf;
}

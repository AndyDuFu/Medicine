package com.medicine.domain.menu;

import com.medicine.domain.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 平台数据详情
 *  根据不同平台类型 属性字段各不相同
 */
@Data
@Entity
@Table(name = "platform_manager_data")
public class PlatformManagerData extends BaseEntity {

    // 管理id
    @Column(name = "pm_id")
    private Long pmId;

    private String x1;

    private String x2;

    private String x3;

    private String x4;

    private String x5;

    private String x6;

    private String x7;

    private String x8;

    private String x9;

    private String x10;

    private String x11;

    private String x12;

    private String x13;

    private String x14;

    private String x15;

    private String x16;

    private String x17;

    private String x18;

    private String x19;

    private String x20;

    private String x21;

    private String x22;

    private String x23;

    private String x24;

    private String x25;

    private PlatformManager platformManager;

}

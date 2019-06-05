package com.medicine.domain.menu;

import com.medicine.domain.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "platform_manager")
public class PlatformManager extends BaseEntity {

    // 父级编号
    @Column(name = "f_class")
    private Long fClass;

    // 是否菜单 0:表示内容 1表示菜单
    @Column(name = "is_menu")
    private Integer isMenu;

    // 表示几级菜单
    private Integer type;


    // 菜单类型
    /**
     *  中医疾病管理 cdm  西医疾病管理  wdm 证候管理      zh
     *  舌诊管理    sz    饮片管理     yp  中药管理      zy
     *  治则治法管理 zzzf  脉诊管理     mz  功能类型管理  gxlx
     *  方剂管理    fj    方剂主治管理  fjzz 症状管理     zz
     *  成分管理    cf
     */
    @Column(name = "sys_type")
    private String sysType;


    private String name;
}

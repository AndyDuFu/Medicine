package com.medicine.domain.dtoAndFrom.menu;


import com.medicine.domain.menu.PlatformManager;
import com.medicine.domain.menu.PlatformManagerData;
import com.medicine.domain.menu.Prescription;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Getter
@Setter
public class SuperManager {
    private Long fClass;
    private Long id;
    private String name;
    private Long key;
    private Integer type;
    private String sysType;
    private Integer isMenu;

    public  PlatformManager managerToPlatformConvert(SuperManager cdmManager) {
        PlatformManager platformManager = new PlatformManager();
        BeanUtils.copyProperties(cdmManager, platformManager);
        return platformManager;
    }

    /**
     * 设置记录 不同管理记录不同所以需要各个子类自己重写
     * @param cdmManager
     * @return
     */
    public PlatformManagerData managerToPlatformConvertData(SuperManager cdmManager) {
        return null;
    }

    /**
     * 返回每个管理的记录 因为不同管理记录不同，所以子类需要实现其方法
     * @param platformManager
     * @param platformManagerData
     * @return
     */
    public  SuperManager platformToCdmManagerConvert(PlatformManager platformManager, PlatformManagerData platformManagerData) {
        return null;
    }


    /**
     * Fj 特殊的管理
     * @param platformManager
     * @param platformManagerData
     * @param prescriptions
     * @return
     */
    public SuperManager platformToCdmManagerConvert(PlatformManager platformManager, PlatformManagerData platformManagerData, List<Prescription> prescriptions) {
        return null;
    }
}

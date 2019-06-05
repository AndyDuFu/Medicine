package com.medicine.domain.dtoAndFrom.menu;

import com.medicine.domain.menu.PlatformManager;
import com.medicine.domain.menu.PlatformManagerData;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;


/**
 * 治则治法管理
 */
@Getter
@Setter
public class ZzzFmManager extends SuperManager {
    private String bm;
    private String bz;
    private String ms;

    @Override
    public SuperManager platformToCdmManagerConvert(PlatformManager platformManager, PlatformManagerData platformManagerData) {
        ZzzFmManager zzzFmManager = new ZzzFmManager();
        BeanUtils.copyProperties(platformManager, zzzFmManager);
        zzzFmManager.setKey(platformManager.getId());
        zzzFmManager.setBm(platformManagerData.getX1());
        zzzFmManager.setBz(platformManagerData.getX2());
        zzzFmManager.setMs(platformManagerData.getX3());
        return zzzFmManager;
    }

    @Override
    public PlatformManagerData managerToPlatformConvertData(SuperManager superManager) {
        ZzzFmManager zzzFmManager = (ZzzFmManager) superManager;
        PlatformManagerData platformManagerData = new PlatformManagerData();
        platformManagerData.setX1(zzzFmManager.getBm());
        platformManagerData.setX2(zzzFmManager.getBz());
        platformManagerData.setX3(zzzFmManager.getMs());
        return platformManagerData;
    }
}

package com.medicine.domain.dtoAndFrom.menu;

import com.medicine.domain.menu.PlatformManager;
import com.medicine.domain.menu.PlatformManagerData;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;


/**
 * 症状管理
 */
@Getter
@Setter
public class ZzManager extends SuperManager {
    private String bx;
    private String by;
    private String bzyd;
    private String fxlz;
    private String gk;
    private String glzh;
    private String glzz;
    private String jbzd;
    private String ldyjls;
    private String qt;
    private String xgyxjb;
    private String zdyd;
    private String zgyh;
    private String zlyz;

    @Override
    public SuperManager platformToCdmManagerConvert(PlatformManager platformManager, PlatformManagerData platformManagerData) {
        ZzManager zzManager = new ZzManager();
        BeanUtils.copyProperties(platformManager, zzManager);
        zzManager.setKey(platformManager.getId());
        zzManager.setBx(platformManagerData.getX1());
        zzManager.setBy(platformManagerData.getX2());
        zzManager.setBzyd(platformManagerData.getX3());
        zzManager.setFxlz(platformManagerData.getX4());
        zzManager.setGk(platformManagerData.getX5());
        zzManager.setGlzh(platformManagerData.getX6());
        zzManager.setGlzz(platformManagerData.getX7());
        zzManager.setJbzd(platformManagerData.getX8());
        zzManager.setLdyjls(platformManagerData.getX9());
        zzManager.setQt(platformManagerData.getX10());
        zzManager.setXgyxjb(platformManagerData.getX11());
        zzManager.setZdyd(platformManagerData.getX12());
        zzManager.setZgyh(platformManagerData.getX13());
        zzManager.setZlyz(platformManagerData.getX14());
        return zzManager;
    }

    @Override
    public PlatformManagerData managerToPlatformConvertData(SuperManager superManager) {
        ZzManager zzManager = (ZzManager) superManager;
        PlatformManagerData platformManagerData = new PlatformManagerData();
        platformManagerData.setX1(zzManager.getBx());
        platformManagerData.setX2(zzManager.getBy());
        platformManagerData.setX3(zzManager.getBzyd());
        platformManagerData.setX4(zzManager.getFxlz());
        platformManagerData.setX5(zzManager.getGk());
        platformManagerData.setX6(zzManager.getGlzh());
        platformManagerData.setX7(zzManager.getGlzz());
        platformManagerData.setX8(zzManager.getJbzd());
        platformManagerData.setX9(zzManager.getLdyjls());
        platformManagerData.setX10(zzManager.getQt());
        platformManagerData.setX11(zzManager.getXgyxjb());
        platformManagerData.setX12(zzManager.getZdyd());
        platformManagerData.setX13(zzManager.getZgyh());
        platformManagerData.setX14(zzManager.getZlyz());
        return platformManagerData;
    }
}

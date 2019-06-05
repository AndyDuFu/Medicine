package com.medicine.domain.dtoAndFrom.menu;

import com.medicine.domain.menu.PlatformManager;
import com.medicine.domain.menu.PlatformManagerData;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

/**
 * 西医疾病管理
 */
@Getter
@Setter
public class WdmManager extends SuperManager {

    private String by;
    private String fbjz;
    private String gk;
    private String jb;
    private String jbzd;
    private String lhjc;
    private String tz;
    private String yh;

    @Override
    public  SuperManager platformToCdmManagerConvert(PlatformManager platformManager, PlatformManagerData platformManagerData) {
        WdmManager cdmManager = new WdmManager();
        BeanUtils.copyProperties(platformManager, cdmManager);
        cdmManager.setKey(platformManager.getId());
        cdmManager.setBy(platformManagerData.getX1());
        cdmManager.setFbjz(platformManagerData.getX2());
        cdmManager.setGk(platformManagerData.getX3());
        cdmManager.setJb(platformManagerData.getX4());
        cdmManager.setJbzd(platformManagerData.getX5());
        cdmManager.setLhjc(platformManagerData.getX6());
        cdmManager.setTz(platformManagerData.getX7());
        cdmManager.setYh(platformManagerData.getX8());

        return cdmManager;
    }

    @Override
    public  PlatformManagerData managerToPlatformConvertData(SuperManager superManager) {
        WdmManager wdmManager = (WdmManager) superManager;
        PlatformManagerData platformManagerData = new PlatformManagerData();
        platformManagerData.setX1(wdmManager.getBy());
        platformManagerData.setX2(wdmManager.getFbjz());
        platformManagerData.setX3(wdmManager.getGk());
        platformManagerData.setX4(wdmManager.getJb());
        platformManagerData.setX5(wdmManager.getJbzd());
        platformManagerData.setX6(wdmManager.getLhjc());
        platformManagerData.setX7(wdmManager.getTz());
        platformManagerData.setX8(wdmManager.getYh());
        return platformManagerData;
    }

}

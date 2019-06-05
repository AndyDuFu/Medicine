package com.medicine.domain.dtoAndFrom.menu;

import com.medicine.domain.menu.PlatformManager;
import com.medicine.domain.menu.PlatformManagerData;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

/**
 * 饮片管理
 */
@Getter
@Setter
public class YpManager extends SuperManager {

    private String bz;
    private String pzff;
    private String ycbw;
    private String zyc;

    @Override
    public SuperManager platformToCdmManagerConvert(PlatformManager platformManager, PlatformManagerData platformManagerData) {
        YpManager ypManager = new YpManager();
        BeanUtils.copyProperties(platformManager, ypManager);
        ypManager.setKey(platformManager.getId());
        ypManager.setBz(platformManagerData.getX1());
        ypManager.setPzff(platformManagerData.getX2());
        ypManager.setYcbw(platformManagerData.getX3());
        ypManager.setZyc(platformManagerData.getX4());
        return ypManager;
    }

    @Override
    public PlatformManagerData managerToPlatformConvertData(SuperManager superManager) {
        YpManager ypManager = (YpManager) superManager;
        PlatformManagerData platformManagerData = new PlatformManagerData();
        platformManagerData.setX1(ypManager.getBz());
        platformManagerData.setX2(ypManager.getPzff());
        platformManagerData.setX3(ypManager.getYcbw());
        platformManagerData.setX4(ypManager.getZyc());
        return platformManagerData;
    }
}

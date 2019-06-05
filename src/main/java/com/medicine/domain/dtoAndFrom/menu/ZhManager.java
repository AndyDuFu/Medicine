package com.medicine.domain.dtoAndFrom.menu;


import com.medicine.domain.menu.PlatformManager;
import com.medicine.domain.menu.PlatformManagerData;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;


/**
 * 证候管理
 */
@Getter
@Setter
public class ZhManager extends SuperManager {
    private String bm;
    private String bz;
    private String ms;

    @Override
    public SuperManager platformToCdmManagerConvert(PlatformManager platformManager, PlatformManagerData platformManagerData) {
        ZhManager cdmManager = new ZhManager();
        BeanUtils.copyProperties(platformManager, cdmManager);
        cdmManager.setKey(platformManager.getId());
        cdmManager.setBm(platformManagerData.getX1());
        cdmManager.setBz(platformManagerData.getX2());
        cdmManager.setMs(platformManagerData.getX3());
        return cdmManager;
    }

    @Override
    public PlatformManagerData managerToPlatformConvertData(SuperManager superManager) {
        ZhManager zhManager = (ZhManager) superManager;
        PlatformManagerData platformManagerData = new PlatformManagerData();
        platformManagerData.setX1(zhManager.getBm());
        platformManagerData.setX2(zhManager.getBz());
        platformManagerData.setX3(zhManager.getMs());
        return platformManagerData;
    }
}
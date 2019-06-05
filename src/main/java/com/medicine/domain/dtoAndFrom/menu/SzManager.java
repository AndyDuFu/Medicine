package com.medicine.domain.dtoAndFrom.menu;


import com.medicine.domain.menu.PlatformManager;
import com.medicine.domain.menu.PlatformManagerData;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;


/**
 * 舌诊管理
 */
@Getter
@Setter
public class SzManager extends SuperManager{
   private String bm;
   private String bz;
   private String ms;

    @Override
    public SuperManager platformToCdmManagerConvert(PlatformManager platformManager, PlatformManagerData platformManagerData) {
        SzManager szManager = new SzManager();
        BeanUtils.copyProperties(platformManager, szManager);
        szManager.setKey(platformManager.getId());
        szManager.setBm(platformManagerData.getX1());
        szManager.setBz(platformManagerData.getX2());
        szManager.setMs(platformManagerData.getX3());
        return szManager;
    }

    @Override
    public PlatformManagerData managerToPlatformConvertData(SuperManager superManager) {
        SzManager szManager = (SzManager) superManager;
        PlatformManagerData platformManagerData = new PlatformManagerData();
        platformManagerData.setX1(szManager.getBm());
        platformManagerData.setX2(szManager.getBz());
        platformManagerData.setX3(szManager.getMs());
        return platformManagerData;
    }
}

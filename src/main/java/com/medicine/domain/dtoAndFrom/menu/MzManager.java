package com.medicine.domain.dtoAndFrom.menu;

import com.medicine.domain.menu.PlatformManager;
import com.medicine.domain.menu.PlatformManagerData;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;


/**
 * 脉诊管理
 */
@Getter
@Setter
public class MzManager extends SuperManager{

    private String bm;
    private String bz;
    private String ms;

    @Override
    public SuperManager platformToCdmManagerConvert(PlatformManager platformManager, PlatformManagerData platformManagerData) {
        MzManager mzManager = new MzManager();
        BeanUtils.copyProperties(platformManager, mzManager);
        mzManager.setKey(platformManager.getId());
        mzManager.setBm(platformManagerData.getX1());
        mzManager.setBz(platformManagerData.getX2());
        mzManager.setMs(platformManagerData.getX3());
        return mzManager;
    }

    @Override
    public PlatformManagerData managerToPlatformConvertData(SuperManager superManager) {
        MzManager mzManager = (MzManager) superManager;
        PlatformManagerData platformManagerData = new PlatformManagerData();
        platformManagerData.setX1(mzManager.getBm());
        platformManagerData.setX2(mzManager.getBz());
        platformManagerData.setX3(mzManager.getMs());
        return platformManagerData;
    }
}

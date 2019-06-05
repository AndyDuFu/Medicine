package com.medicine.domain.dtoAndFrom.menu;

import com.medicine.domain.menu.PlatformManager;
import com.medicine.domain.menu.PlatformManagerData;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;


/**
 * 功效类型管理
 */
@Getter
@Setter
public class GxlxManager extends SuperManager {
    private String bz;

    @Override
    public SuperManager platformToCdmManagerConvert(PlatformManager platformManager, PlatformManagerData platformManagerData) {
        GxlxManager gxlxManager = new GxlxManager();
        BeanUtils.copyProperties(platformManager, gxlxManager);
        gxlxManager.setKey(platformManager.getId());
        gxlxManager.setBz(platformManagerData.getX1());
        return gxlxManager;
    }

    @Override
    public PlatformManagerData managerToPlatformConvertData(SuperManager superManager) {
        GxlxManager mzManager = (GxlxManager) superManager;
        PlatformManagerData platformManagerData = new PlatformManagerData();
        platformManagerData.setX1(mzManager.getBz());
        return platformManagerData;
    }
}

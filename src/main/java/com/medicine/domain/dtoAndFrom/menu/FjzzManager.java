package com.medicine.domain.dtoAndFrom.menu;

import com.medicine.domain.menu.PlatformManager;
import com.medicine.domain.menu.PlatformManagerData;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;


/**
 * 方剂主治管理
 */
@Getter
@Setter
public class FjzzManager extends SuperManager {
    private String bm;
    private String bz;
    private String ms;

    @Override
    public SuperManager platformToCdmManagerConvert(PlatformManager platformManager, PlatformManagerData platformManagerData) {
        FjzzManager fjzzManager = new FjzzManager();
        BeanUtils.copyProperties(platformManager, fjzzManager);
        fjzzManager.setKey(platformManager.getId());
        fjzzManager.setBm(platformManagerData.getX1());
        fjzzManager.setBz(platformManagerData.getX2());
        fjzzManager.setMs(platformManagerData.getX3());
        return fjzzManager;
    }

    @Override
    public PlatformManagerData managerToPlatformConvertData(SuperManager superManager) {
        FjzzManager fjzzManager = (FjzzManager) superManager;
        PlatformManagerData platformManagerData = new PlatformManagerData();
        platformManagerData.setX1(fjzzManager.getBm());
        platformManagerData.setX2(fjzzManager.getBz());
        platformManagerData.setX3(fjzzManager.getMs());
        return platformManagerData;
    }
}

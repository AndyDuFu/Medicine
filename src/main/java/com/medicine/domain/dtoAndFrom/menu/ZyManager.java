package com.medicine.domain.dtoAndFrom.menu;


import com.medicine.domain.menu.PlatformManager;
import com.medicine.domain.menu.PlatformManagerData;
import com.medicine.util.CharacterUtils;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ZyManager extends SuperManager {

    private String szmdx;
    private String ywmc;

    /** 科 */
    private List<String> ke;

    /** 属 */
    private List<String> su;
    private String ldmc;
    private String xz;
    private String jy;
    private String bm;
    private String yfyl;
    private String yybw;
    /** 四气 */
    private List<String> sq;

    /** 五味 */
    private List<String> ww;

    /** 归茎 */
    private List<String> gj;

    private List<String> zzjb;
    private List<String> glzz;
    private List<String> ylzz;
    private List<String> hxcf;
    private List<String> glzl;
    private String tp;

    private String bz;
    private String pzff;
    private String ycbw;
    private String zyc;


    public List<ZyManager> convert(List<PlatformManagerData> platformManagerData) {
        List<ZyManager> zyManagers = new ArrayList<>();
        platformManagerData.forEach(e->zyManagers.add((ZyManager)platformToCdmManagerConvert(e.getPlatformManager(), e)));
        return zyManagers;
    }

    @Override
    public SuperManager platformToCdmManagerConvert(PlatformManager platformManager, PlatformManagerData platformManagerData) {
        ZyManager zyManager = new ZyManager();
        BeanUtils.copyProperties(platformManager, zyManager);
        zyManager.setKey(platformManager.getId());
        zyManager.setBz(platformManagerData.getX1());
        zyManager.setPzff(platformManagerData.getX2());
        zyManager.setYcbw(platformManagerData.getX3());
        zyManager.setZyc(platformManagerData.getX4());

        zyManager.setSzmdx(platformManagerData.getX5());
        zyManager.setYwmc(platformManagerData.getX7());
        zyManager.setKe(CharacterUtils.stringTochars(platformManagerData.getX8()));
        zyManager.setSu(CharacterUtils.stringTochars(platformManagerData.getX9()));
        zyManager.setLdmc(platformManagerData.getX10());
        zyManager.setXz(platformManagerData.getX11());
        zyManager.setJy(platformManagerData.getX12());
        zyManager.setBm(platformManagerData.getX13());
        zyManager.setYfyl(platformManagerData.getX14());
        zyManager.setYybw(platformManagerData.getX15());
        zyManager.setSq(CharacterUtils.stringTochars(platformManagerData.getX16()));
        zyManager.setWw(CharacterUtils.stringTochars(platformManagerData.getX17()));
        zyManager.setGj(CharacterUtils.stringTochars(platformManagerData.getX18()));
        zyManager.setZzjb(CharacterUtils.stringTochars(platformManagerData.getX19()));
        zyManager.setGlzz(CharacterUtils.stringTochars(platformManagerData.getX20()));
        zyManager.setYlzz(CharacterUtils.stringTochars(platformManagerData.getX21()));
        zyManager.setHxcf(CharacterUtils.stringTochars(platformManagerData.getX22()));
        zyManager.setTp(platformManagerData.getX23());
        zyManager.setBz(platformManagerData.getX24());
        zyManager.setGlzl(CharacterUtils.stringTochars(platformManagerData.getX25()));

        return zyManager;
    }

    @Override
    public PlatformManagerData managerToPlatformConvertData(SuperManager superManager) {
        ZyManager zyManager = (ZyManager) superManager;
        PlatformManagerData platformManagerData = new PlatformManagerData();
        platformManagerData.setX1(zyManager.getBz());
        platformManagerData.setX2(zyManager.getPzff());
        platformManagerData.setX3(zyManager.getYcbw());
        platformManagerData.setX4(zyManager.getZyc());

        platformManagerData.setX5(zyManager.getSzmdx());
        platformManagerData.setX7(zyManager.getYwmc());
        platformManagerData.setX8(CharacterUtils.charsToString(zyManager.getKe()));
        platformManagerData.setX9(CharacterUtils.charsToString(zyManager.getSu()));
        platformManagerData.setX10(zyManager.getLdmc());
        platformManagerData.setX11(zyManager.getXz());
        platformManagerData.setX12(zyManager.getJy());
        platformManagerData.setX13(zyManager.getBm());
        platformManagerData.setX14(zyManager.getYfyl());
        platformManagerData.setX15(zyManager.getYybw());
        platformManagerData.setX16(CharacterUtils.charsToString(zyManager.getSq()));
        platformManagerData.setX17(CharacterUtils.charsToString(zyManager.getWw()));
        platformManagerData.setX18(CharacterUtils.charsToString(zyManager.getGj()));
        platformManagerData.setX19(CharacterUtils.charsToString(zyManager.getZzjb()));
        platformManagerData.setX20(CharacterUtils.charsToString(zyManager.getGlzz()));
        platformManagerData.setX21(CharacterUtils.charsToString(zyManager.getYlzz()));
        platformManagerData.setX22(CharacterUtils.charsToString(zyManager.getHxcf()));
        platformManagerData.setX23(zyManager.getTp());
        platformManagerData.setX24(zyManager.getBz());
        platformManagerData.setX25(CharacterUtils.charsToString(zyManager.getGlzl()));

        return platformManagerData;
    }
}

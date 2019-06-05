package com.medicine.domain.dtoAndFrom.menu;

import com.medicine.domain.menu.PlatformManager;
import com.medicine.domain.menu.PlatformManagerData;
import com.medicine.domain.menu.Prescription;
import com.medicine.util.CharacterUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;


/**
 * 方剂管理
 */
@Getter
@Setter
public class FjManager extends SuperManager {
    /** 备注 */
    private String bz;

    /** 朝代 */
    private String cd;

    /** 处方来源 */
    private String cfly;

    /** 处方医师 */
    private String cfys;

    /** 方剂功效 */
    private List<String> fjgx;
    private String fjlx;
    private String fjmz;

    /** 方剂主治 */
    private List<String> fjzz;

    /** 给药途径 */
    private String gytj;

    /** 煎服方法 */
    private String jfff;

    /** 剂型 */
    private String jx;

    /** 适宜证候 */
    private List<String> syzh;
    private String zymc;
    private String zyyf;
    private String zyyl;
    private String zyzy;

    /** 中医症状 */
    private List<String> zyzz;

    /** 西医疾病 */
    private List<String> xyjb;
    /** 中医疾病 */
    private List<String> zyjb;

    /** 处方明细 */
    private List<Prescription> cf;

    private String syzhs;
    private String zyzzs;
    private String zzxyjbs;
    private String zzzyjbs;
    private String fjzzs;
    private String fjgxs;
    /**
     *
     * @param platformManager
     * @param platformManagerData
     * @param prescriptions
     * @return
     */

    public SuperManager platformToCdmManagerConvert(PlatformManager platformManager, PlatformManagerData platformManagerData, List<Prescription> prescriptions) {
        FjManager fjManager = new FjManager();
        BeanUtils.copyProperties(platformManager, fjManager);
        fjManager.setCf(prescriptions);
        if (platformManagerData != null) {
            fjManager.setKey(platformManager.getId());
            fjManager.setBz(platformManagerData.getX1());
            fjManager.setCd(platformManagerData.getX2());
            fjManager.setCfly(platformManagerData.getX3());
            fjManager.setCfys(platformManagerData.getX4());
            fjManager.setFjgx(CharacterUtils.stringTochars(platformManagerData.getX5()));
            fjManager.setFjlx(platformManagerData.getX6());
            fjManager.setFjmz(platformManagerData.getX7());
            fjManager.setFjzz(CharacterUtils.stringTochars(platformManagerData.getX8()));
            fjManager.setGytj(platformManagerData.getX9());
            fjManager.setJfff(platformManagerData.getX10());
            fjManager.setJx(platformManagerData.getX11());
            fjManager.setSyzh(CharacterUtils.stringTochars(platformManagerData.getX12()));
            fjManager.setZymc(platformManagerData.getX13());
            fjManager.setZyyf(platformManagerData.getX14());
            fjManager.setZyyl(platformManagerData.getX15());
            fjManager.setZyzy(platformManagerData.getX16());
            fjManager.setZyzz(CharacterUtils.stringTochars(platformManagerData.getX17()));
            fjManager.setXyjb(CharacterUtils.stringTochars(platformManagerData.getX18()));
            fjManager.setZyjb(CharacterUtils.stringTochars(platformManagerData.getX19()));
        }
        return fjManager;
    }

    @Override
    public PlatformManagerData managerToPlatformConvertData(SuperManager superManager) {
        FjManager fjManager = (FjManager) superManager;
        PlatformManagerData platformManagerData = new PlatformManagerData();
        platformManagerData.setX1(fjManager.getBz());
        platformManagerData.setX2(fjManager.getCd());
        platformManagerData.setX3(fjManager.getCfly());
        platformManagerData.setX4(fjManager.getCfys());
        platformManagerData.setX5(CharacterUtils.charsToString(fjManager.getFjgx()));
        platformManagerData.setX6(fjManager.getFjlx());
        platformManagerData.setX7(fjManager.getFjmz());
        platformManagerData.setX8(CharacterUtils.charsToString(fjManager.getFjzz()));
        platformManagerData.setX9(fjManager.getGytj());
        platformManagerData.setX10(fjManager.getJfff());
        platformManagerData.setX11(fjManager.getJx());
        platformManagerData.setX12(CharacterUtils.charsToString(fjManager.getSyzh()));
        platformManagerData.setX13(fjManager.getZymc());
        platformManagerData.setX14(fjManager.getZyyf());
        platformManagerData.setX15(fjManager.getZyyl());
        platformManagerData.setX16(fjManager.getZyzy());
        platformManagerData.setX17(CharacterUtils.charsToString(fjManager.getZyzz()));
        platformManagerData.setX18(CharacterUtils.charsToString(fjManager.getXyjb()));
        platformManagerData.setX19(CharacterUtils.charsToString(fjManager.getZyjb()));
        return platformManagerData;
    }

}

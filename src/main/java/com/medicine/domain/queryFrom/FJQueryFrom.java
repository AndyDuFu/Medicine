package com.medicine.domain.queryFrom;

import lombok.Getter;
import lombok.Setter;


/**
 * 这个对应字段需要到FjManager 中的platformToCdmManagerConvert
 * 查找对应字段的意思。。
 *
 */
@Getter
@Setter
public class FJQueryFrom {

    /** 方剂名称 */
    private String name;

    /** 处方来源 */
    private String cfly;

    /** 处方医师 */
    private String cfys;

    /** TODO 中药名 */
    private String cfName;

    /** 中医疾病 */
    private String zyjb;

    /** 西医疾病 */
    private String xyjb;

    /** 中医症状 */
    private String zyzz;

    /** 方剂主治 */
    private String fjzz;

    /** TODO 中医证候 */
    private String zyzh;

    /** 方剂类别 */
    private String fjgx;

    /** 给药类别 */
    private String gytj;

    /** 来源医案 */
    private Integer lyya;
    
    private String syzh;


    public static FJQueryFrom getInstance(String condition) {
    	FJQueryFrom fJQueryFrom = new FJQueryFrom();
    	fJQueryFrom.setName(condition);
    	fJQueryFrom.setCfly(condition);
    	fJQueryFrom.setCfys(condition);
    	fJQueryFrom.setCfName(condition);
    	fJQueryFrom.setZyjb(condition);
    	fJQueryFrom.setXyjb(condition);
    	fJQueryFrom.setZyzz(condition);
    	fJQueryFrom.setFjzz(condition);
    	fJQueryFrom.setZyzh(condition);
    	fJQueryFrom.setFjgx(condition);
    	fJQueryFrom.setGytj(condition);
    	fJQueryFrom.setZyzh(condition);
    	return fJQueryFrom;
    }
}

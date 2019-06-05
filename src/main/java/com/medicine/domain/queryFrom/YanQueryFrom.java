package com.medicine.domain.queryFrom;


import com.medicine.util.DatetimeUtil;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class YanQueryFrom {

    private String name;

    /** 处方名称 */
    private String zfm;

    /** 西医疾病 */
    private String xyjb;

    /** 中医疾病 */
    private String zyjb;

    /** 中医证候 */
    private String zyzh;

    /** 中医症状 */
    private String zhenzhuang;

    /** 处方医师 */
    private String doctor;
    
    /* 最小年龄 */
    private Integer minAge;
    
    /* 最大年龄 */
    private Integer maxAge;
    
    /* 开始时间 */
    private String startDate;
    
    /* 结束时间 */
    private String endDate;
    
    /* 治则治法 */
    private String zzzf;
    
    /* 处方类型 */
    private String type;
    
    /* 中成药 */
    private String medicinec;
    
    /* 西成药 */
    private String medicinew;
    
    /* 西医检查各种类型 */
    private String text;
    
    /* 处方中药名 */
    private String meName;
    
    /* 处方中药作用 */
    private String zhuyong;
    
    /* 西医检查-体格检查 */
    private String tigejiancha;
    
    public static YanQueryFrom getInstance(Integer minAge, Integer maxAge, String startDate, String endDate, String condition) {
    	YanQueryFrom yanQueryFrom = new YanQueryFrom();
    	yanQueryFrom.setName(condition);
    	yanQueryFrom.setZfm(condition);
    	yanQueryFrom.setXyjb(condition);
    	yanQueryFrom.setZyjb(condition);
    	yanQueryFrom.setZyzh(condition);
    	yanQueryFrom.setZhenzhuang(condition);
    	yanQueryFrom.setDoctor(condition);
    	yanQueryFrom.setMinAge(minAge);
    	yanQueryFrom.setMaxAge(maxAge);
    	yanQueryFrom.setZzzf(condition);
    	yanQueryFrom.setType(condition);
    	yanQueryFrom.setMedicinec(condition);
    	yanQueryFrom.setMedicinew(condition);
    	yanQueryFrom.setText(condition);
    	yanQueryFrom.setMeName(condition);
    	yanQueryFrom.setZhuyong(condition);
    	yanQueryFrom.setTigejiancha(condition);
    	
    	if(null == startDate || null == endDate) {
    		yanQueryFrom.setStartDate("0000-00-00");
    		yanQueryFrom.setEndDate("0000-00-00");
    	} else if(!startDate.equals(endDate)) {
    		yanQueryFrom.setStartDate(startDate);
    		yanQueryFrom.setEndDate(DatetimeUtil.getNextDay(endDate));
    	} else if(startDate.equals(endDate)) {
    		yanQueryFrom.setStartDate(startDate);
    		yanQueryFrom.setEndDate(endDate);
    	}
    	
    	return yanQueryFrom;
    }
}

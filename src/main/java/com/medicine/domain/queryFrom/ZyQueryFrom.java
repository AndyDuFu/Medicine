package com.medicine.domain.queryFrom;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ZyQueryFrom {


    private String name;

    private String jy;

    private String xwgj;

    private String glzz;

    private String xz;

    private Integer type;

 
    public static ZyQueryFrom getInstance(String condition) {
    	ZyQueryFrom zyQueryFrom = new ZyQueryFrom();
    	zyQueryFrom.setName(condition);
    	zyQueryFrom.setJy(condition);
    	zyQueryFrom.setXwgj(condition);
    	zyQueryFrom.setGlzz(condition);
    	zyQueryFrom.setXz(condition);
		return zyQueryFrom;
    }
}

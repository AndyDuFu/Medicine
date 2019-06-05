package com.medicine.batch.install.enums;

/**
 * @author FuDu
 * @date 2019-03-15
 */ 
public enum VisitRecordEnum {
	CREATE_DATE("createDate", "记录创建日期");
	private String value;
	private String desc;
	private VisitRecordEnum(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	public String value() {
		return value;
	}
	public String desc() {
		return desc;
	}
}

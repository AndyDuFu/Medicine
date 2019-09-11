package com.medicine.batch.install.enums;

/**
 * @author FuDu
 * @date 2019-03-14
 * @desc 该类主要用于批量导入病患信息时 CSV 文件头的固定格式
 */
public enum PatientEnum {
	NAME("name", "姓名"), SEX("sex", "性别"), AGE("age", "年龄"), PHONE("phone", "电话"),
	ADDRESS("address", "地址"), BIRTHPLACE("birthplace", "出生地"), ZIPCODE("zipCode", "邮编"),
	MARRIAGE("marriage", "婚姻状况"), NOTMARRIED("0", "未婚"), MARRIED("1", "已婚"),
	CITIZENSHIP("citizenship", "国籍"), PROFESSION("profession", "职业"), ETHNIC("ethnic", "民族"), 
	WEIGHT("weight", "体重");
	private String value;
	private String desc;
	private PatientEnum(String value, String desc) {
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

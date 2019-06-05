package com.medicine.batch.install.enums;

/**
 * @author FuDu
 * @date 2019-03-15
 * @desc 该类主要用于批量导入就诊信息时西医检查部分 CSV 文件头的固定格式
 */ 
public enum WestMedEnum {
	BODYCHECK("tigejiancha", "体格检查"), WESTERNMEDICINES("westernMedicines", "所有检查报告");
	private String value;
	private String desc;
	private WestMedEnum(String value, String desc) {
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

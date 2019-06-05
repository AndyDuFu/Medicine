package com.medicine.batch.install.enums;

/**
 * @author FuDu
 * @date 2019-04-03
 * @desc 一些关于导出 xls 文件的设置
 */
public enum ExcelEnum {
	EXCEL_XLS_SUFFIX(".xls", "xls文件格式"),
	EXCEL_XLS_SHEET_PV("patien-visiting record", "病患-就诊记录");
	private String value;
	private String desc;
	private ExcelEnum(String value, String desc) {
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

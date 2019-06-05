package com.medicine.batch.install.enums;

public enum DateFormat {
	FORMAT1("yyyy-MM-dd HH:mm:ss"), 
	FORMAT2("yyyy/MM/dd HH:mm:ss"), 
	FORMAT3("1000-01-01 00:00:00"),
	FORMAT4("yyyyMMddHHmmss");
	private String format;
	private DateFormat(String format) {
		this.format = format;
	}
	public String format() {
		return format;
	}
}

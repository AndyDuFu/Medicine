package com.medicine.data;

public enum LogFile {
	LOG_ADDIR("/alidata/log/medicine"), LOG_GZ(".gz");
	private String info;
	private LogFile(String info) {
		this.info = info;
	}
	public String getInfo() {
		return info;
	}
}

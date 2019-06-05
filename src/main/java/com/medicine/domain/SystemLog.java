package com.medicine.domain;

public class SystemLog {
	private String logName;
	private String logPath;
	public String getLogName() {
		return logName;
	}
	public void setLogName(String logName) {
		this.logName = logName;
	}
	public String getLogPath() {
		return logPath;
	}
	public void setLogPath(String logPath) {
		this.logPath = logPath;
	}
	@Override
	public String toString() {
		return "SystemLog [logName=" + logName + ", logPath=" + logPath + "]";
	}
}

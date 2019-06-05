package com.medicine.data;


import com.medicine.domain.CustomerSession;
import com.medicine.domain.User;

public enum UserType {
	CUSTOMER(CustomerSession.class, User.class, "-c");

	private Class<?> sessionClass;
	private Class<?> accountClass;
	private String suffix;

	private UserType(Class<?> sessionClass,
                     Class<?> accountClass, String suffix) {
		this.sessionClass = sessionClass;
		this.accountClass = accountClass;
		this.suffix = suffix;

	}

	public Class<?> getSessionClass() {
		return sessionClass;
	}

	public String getSuffix() {
		return suffix;
	}

	public Class<?> getAccountClass() {
		return accountClass;
	}
}

package com.medicine.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ErrorMessagePropertiesUtil {

	private Properties prop;

	private static final ErrorMessagePropertiesUtil util = new ErrorMessagePropertiesUtil();

	public static ErrorMessagePropertiesUtil getInstance() {
		return util;
	}

	private ErrorMessagePropertiesUtil() {
		init();
	}

	private void init() {
		InputStream in = ErrorMessagePropertiesUtil.class.getClassLoader()
				.getResourceAsStream("error_message_zh.properties");

		prop = new Properties();
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getString(String key, String defaultValue) {
		return prop.getProperty(key, defaultValue);
	}

	public String getString(String key) {
		return prop.getProperty(key);
	}

	public Integer getInt(String key, Integer defaultValue) {
		return Integer.parseInt(prop.getProperty(key, defaultValue.toString()));
	}

	public Integer getInt(String key) {
		return Integer.parseInt(prop.getProperty(key));
	}
}

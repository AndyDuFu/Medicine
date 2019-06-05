package com.medicine.util;

public class Constants {
	public static final String DEFAULT_ENCODE = "UTF-8";
	public static final String AUTH_TOKEN_HEADER_NAME = "authToken";
	public static final String ADMIN_USER_HEADER_NAME = "adminUser";

	public static final String TRANSACTION_ID_NAME = "transactionId";

	public static final String ALIPAY_NOTIFY_URL_KEY = "ALIPAY_NOTIFY_URL";

	public static final String USERNAME_REGEX = "[a-zA-Z0-9_-]+";
	public static final String USERNAME_REGEX_AND_LEN = "[a-zA-Z0-9_-]{4,32}";
	public static final int USERNAME_MIN_LEN = 6;
	public static final int USERNAME_MAX_LEN = 32;

	public static final int REAL_NAME_LEN = 20;

	public static final String PASSWORD_REGEX = "(?=.*?[A-Z]+.*?)(?=.*?[a-z]+.*?)(?=.*?[0-9]+.*?)(?=.*?[\\p{Punct}]+.*?).*";
	public static final String PASSWORD_NEW_REGEX = "(?=.*?[a-zA-Z]+.*?)(?=.*?[0-9]+.*?).*";
	public static final int PASSWORD_MIN_LEN = 6;
	public static final int PASSWORD_MAX_LEN = 32;

	public static final String EMAIL_REGEX = "^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$";
	public static final String ID_CARD_REGEX = "(^\\d{15}$)|(^\\d{17}([0-9]|[X|x])$)";

	public static final String PHONE_REGEX = "(^(\\d{3,4}[-]?)?\\d{7,8})$|^((1[0-9][0-9]\\d{8}$))";

	public static final int DEFAULT_PAGE = 1;
	public static final int DEFAULT_PAGE_SIZE = 10;

	public static final int ADVICE_CONTENT_LEN = 250;

	public static final int BAD_CONSULT_POINTS = 5;

	public static final int BULLETIN_TITLE_LEN = 255;
	public static final int BULLETIN_CONTENT_LEN = 1024 * 100;
	public static final int BULLETIN_SUMMARY_LEN = 100;

	public static final double CONSULT_TRANSFER_RATE = 0.3;
	public static final int COIN_TO_FLOWER_RATE = 10;

	public static final String ANDROID_USER_AGENT = "Android";
	public static final String IOS_USER_AGENT = "IOS";

	public static final String SPLIT_CHAR = ",";

	public static final String HTML_WRAP = "<br/>";
	public static final String HTML_WRAP_2 = "<br/><br/>";

	public static final int HEALTH_INFO_MAX_LEN = 1024;
	public static final int MESSAGE_BULLETING_CONTENT_MAX_LEN = 255;
	public static final int MESSAGE_BULLETING_TITLE_MAX_LEN = 100;

	public static final int DOCTOR_INFO_LEN = 1024;

	public static final int CONSULT_TEXT_FIELD_LEN=200;

}

package com.medicine.util;

import tk.mybatis.mapper.util.StringUtil;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MyUtil {
	public static final char[] PWD_SPECIAL_CHARS = { '!', '@', '#', '$', '%',
			'^', '&', '*', '(', ')', '=', '?', '~', ':', ';' };

	public static final char[] CHARS = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
			'h', 'j', 'k', 'i', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v',
			'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	public static boolean validateReg(String value, String reg) {
		if (value == null) {
			return false;
		}
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}

	public static boolean validPhone(String phone) {
		return validateReg(phone, Constants.PHONE_REGEX);
	}

	public static boolean validateIdNumber(String idNumber) {
		return validateReg(idNumber, Constants.ID_CARD_REGEX);
	}

	public static boolean validateEmail(String email) {
		return validateReg(email, Constants.EMAIL_REGEX);
	}

	public static String generateRandomPassword() {
		StringBuilder builder = new StringBuilder();
		// Create 1 Random Upper case
		Random random = new Random(System.nanoTime());
		int c = random.nextInt(26);
		builder.append((char) (c + 'A'));

		// Create 2 Random lower case
		for (int i = 0; i < 2; i++) {
			c = random.nextInt(26);
			builder.append((char) (c + 'a'));
		}

		// Create 2 Random number
		for (int i = 0; i < 2; i++) {
			builder.append(random.nextInt(10));
		}

		// Create 2 Random special char
		builder.append(PWD_SPECIAL_CHARS[random
				.nextInt(PWD_SPECIAL_CHARS.length)]);

		return builder.toString();
	}

	public static BigDecimal moneyScale(BigDecimal money) {
		return money.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	public static boolean validatePassword(String password) {
		if (password == null || password.length() < Constants.PASSWORD_MIN_LEN
				|| password.length() > Constants.PASSWORD_MAX_LEN) {
			return false;
		}

		return validateReg(password, Constants.PASSWORD_NEW_REGEX);
	}

	public static boolean validateUsername(String username) {
		if (username == null || username.length() < Constants.USERNAME_MIN_LEN
				|| username.length() > Constants.USERNAME_MAX_LEN) {
			return false;
		}

		return validateReg(username, Constants.USERNAME_REGEX);
	}

	public static Map<String, Object> buildMap(String key, Object value) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(key, value);
		return map;
	}

	public static String stripHtmlTags(String html) {
		String noHTMLString = html;
		if (!StringUtil.isEmpty(noHTMLString)) {
			noHTMLString = html.replaceAll("\\<.*?\\>", "");
		}
		return noHTMLString;
	}

	public static String urlDecode(String s) {
		if (s == null) {
			return null;
		}
		try {
			return URLDecoder.decode(s, Constants.DEFAULT_ENCODE);
		} catch (UnsupportedEncodingException e) {
			return s;
		}
	}

	public static String numberListToString(List<? extends Number> list) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
			if (i < list.size() - 1) {
				sb.append(Constants.SPLIT_CHAR);
			}
		}
		return sb.toString();
	}

	public static List<Integer> stringToIntegerList(String ss) {
		String[] splits = ss.split(Constants.SPLIT_CHAR);
		List<Integer> tt = new ArrayList<Integer>();
		for (String s : splits) {
			tt.add(Integer.parseInt(s));
		}
		return tt;
	}

	public static List<Long> stringToLongList(String ss) {
		String[] splits = ss.split(Constants.SPLIT_CHAR);
		List<Long> tt = new ArrayList<Long>();
		for (String s : splits) {
			tt.add(Long.parseLong(s));
		}
		return tt;
	}
}

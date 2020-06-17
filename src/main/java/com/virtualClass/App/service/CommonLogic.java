package com.virtualClass.App.service;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.regex.Pattern;

public class CommonLogic {

	public static boolean isValidNic(String nic) {
		try {

			if (nic.length() == 12 && isNumeric(nic)) {
				return true;
			} else {

				if (nic.length() == 10 && isNumeric(nic.substring(0, 9))
						&& nic.substring(9).toUpperCase().equals("V")) {

					return true;
				} else {
					return false;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return false;
	}

	public static boolean isLengthZeroOrNull(String value) {

		if (value.length() == 0 || value == null) {
			return true;
		}

		return false;
	}

	public static boolean isNumeric(String value) {
		NumberFormat formatter = NumberFormat.getInstance();
		ParsePosition pos = new ParsePosition(0);
		formatter.parse(value, pos);
		return value.length() == pos.getIndex();
	}

	public static boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

	public static boolean isVaildGender(String gender) {

		if (gender.equals("M") || gender.equals("m") || gender.equals("F") || gender.equals("f"))
			return true;

		return false;
	}

}

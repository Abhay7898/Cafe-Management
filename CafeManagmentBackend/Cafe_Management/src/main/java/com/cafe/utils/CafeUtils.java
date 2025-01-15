package com.cafe.utils;

public class CafeUtils {
	
	public static boolean passwordMatch(String password, String confrimPassword) {
		return password != null && confrimPassword != null ? password.equals(confrimPassword) ? true : false : false;
	}
	
}

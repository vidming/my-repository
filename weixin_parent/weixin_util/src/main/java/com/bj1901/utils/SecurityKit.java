package com.bj1901.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityKit {

	/**
	 * 对str进行sha1的加密
	 * @param str
	 * @return
	 */
	public static String sha1(String str) {
		try {
			StringBuffer sb = new StringBuffer();
			MessageDigest digest = MessageDigest.getInstance("sha1");
			digest.update(str.getBytes());
			byte[] digestMsg = digest.digest();
			for(byte b:digestMsg) {
				sb.append(String.format("%02x", b));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		String sha1 = sha1("abcde");
		System.out.println(sha1);
	}
}

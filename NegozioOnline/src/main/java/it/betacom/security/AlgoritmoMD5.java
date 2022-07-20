package it.betacom.security;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AlgoritmoMD5 {
	public static String convertiMD5(String password) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] array = md.digest(password.getBytes(Charset.forName("UTF-8")));
			StringBuffer buffer = new StringBuffer();
			String salt = "k^Rd%fgT9t*t2TA�S5y!s58u_"; 
			for (int i = 0; i < array.length; i++) {
				buffer.append(String.format("%x", array[i]) + salt);
			}
			return buffer.toString();
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}
}

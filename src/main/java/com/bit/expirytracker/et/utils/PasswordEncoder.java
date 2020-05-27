package com.bit.expirytracker.et.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public String encodePassword(String password) {
		String encodedPassword;
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		encodedPassword = encoder.encode(password);
		return encodedPassword;
	}
}

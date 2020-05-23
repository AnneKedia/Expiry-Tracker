package com.bit.expirytracker.et.utils;

import java.util.Random;

public class OTPGenerator {

	private final String numbers = "0123456789";

	Random randomGenerator = new Random();

	public String generateOTP() {
		String otp = "";

		for (int i = 0; i < 4; i++) {
			otp = otp + numbers.charAt(randomGenerator.nextInt(numbers.length()));
		}

		return otp;
	}

}

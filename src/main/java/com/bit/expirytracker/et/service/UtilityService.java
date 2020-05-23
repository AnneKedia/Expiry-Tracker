package com.bit.expirytracker.et.service;
import org.springframework.stereotype.Service;

import com.bit.expirytracker.et.utils.OTPGenerator;

@Service
public class UtilityService {

	public String makeOTP() {
		OTPGenerator otpGenerator =new OTPGenerator();
		return (otpGenerator.generateOTP());
	}
}

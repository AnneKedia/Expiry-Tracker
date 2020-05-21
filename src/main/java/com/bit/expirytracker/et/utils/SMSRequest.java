package com.bit.expirytracker.et.utils;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SMSRequest {
	
	@NotBlank
	private final String phoneNumber;
	
	@NotBlank
	private final String message;

	@Override
	public String toString() {
		return "SMSRequest [phoneNumber=" + phoneNumber + ", message=" + message + "]";
	}

	public SMSRequest(@JsonProperty("phoneNumber") String phoneNumber,@JsonProperty("message") String message) {
		super();
		this.phoneNumber = phoneNumber;
		this.message = message;
		System.out.println(phoneNumber);
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getMessage() {
		return message;
	}
	
	

}

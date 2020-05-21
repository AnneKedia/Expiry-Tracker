package com.bit.expirytracker.et.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bit.expirytracker.et.utils.SMSRequest;
import com.bit.expirytracker.et.utils.SMSSender;

@Service
public class MessageService {

	private final SMSSender smsSender;

	@Autowired
	public MessageService(@Qualifier("twilio") TwilioSMSSender twiliosmsSender) {
		super();
		this.smsSender = twiliosmsSender;
	}
	 public void sendMessage(SMSRequest smsRequest) {
		 smsSender.sendSMS(smsRequest);
	 }
	
}

package com.bit.expirytracker.et.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.bit.expirytracker.et.config.TwilioConfiguration;
import com.twilio.Twilio;

@Configuration
public class TwilioInitializer {
	
	private final TwilioConfiguration twilioConfiguration;
	
	@Autowired
	public TwilioInitializer(TwilioConfiguration twilioConfiguration) {
		this.twilioConfiguration=twilioConfiguration;
		Twilio.init(twilioConfiguration.getAccountSid(), twilioConfiguration.getAuthToken());
	}
	

}

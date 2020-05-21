package com.bit.expirytracker.et.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bit.expirytracker.et.utils.SMSRequest;
import com.bit.expirytracker.et.utils.SMSSender;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

@Service("twilio")
public class TwilioSMSSender implements SMSSender {
	
	@Value("${twilio.trail_number}")
	private String twilioNumber;
	
	@Value("${twilio.whatsapp_number}")
	private String whatsappNumber;

	@Override
	public void sendSMS(SMSRequest smsRequest) {
	
	MessageCreator creator=	Message.creator(
				new PhoneNumber(smsRequest.getPhoneNumber()), 
				new PhoneNumber(twilioNumber),
				smsRequest.getMessage());
	
	
	MessageCreator creator2=Message.creator(
			new PhoneNumber("whatsapp:"+smsRequest.getPhoneNumber()), 
			new PhoneNumber(whatsappNumber),
			smsRequest.getMessage()
			);
	System.out.println(whatsappNumber);
	creator.create();
	creator2.create();
		
	}

}

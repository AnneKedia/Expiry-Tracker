package com.bit.expirytracker.et.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.bit.expirytracker.et.utils.MailRequest;

@Service
public class MailService {

	@Autowired
	private  JavaMailSender mailSender;
	
	 public MailService(JavaMailSender javaMailSender) {
	        this.mailSender = javaMailSender;
	    }

	    public void sendMail(MailRequest mailRequest) {

	    	SimpleMailMessage mailMessage = new SimpleMailMessage();

	        mailMessage.setTo(mailRequest.getToMail());
	        mailMessage.setSubject(mailRequest.getSubject());
	        mailMessage.setText(mailRequest.getMessage());	        
	        mailSender.send(mailMessage);
	    }
}

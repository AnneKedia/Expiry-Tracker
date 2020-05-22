package com.bit.expirytracker.et.utils;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MailRequest {

	@NotBlank
	private String toMail;

	@NotBlank
	private String subject;

	@NotBlank
	private String message;

	public MailRequest(@JsonProperty("mail") String toMail, @JsonProperty("subject") String subject,
			@JsonProperty("message") String message) {
		super();
		this.toMail = toMail;
		this.subject = subject;
		this.message = message;
	}

	public String getToMail() {
		return toMail;
	}

	public void setToMail(String toMail) {
		this.toMail = toMail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

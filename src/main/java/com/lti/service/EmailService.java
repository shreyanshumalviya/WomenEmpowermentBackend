package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

	@Autowired
	MailSender mailSender;

	public void sendEmailForSignup(String email, String text, String subject) {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setTo(email);
		message.setFrom("shreyanshumalviya@gmail.com");
		message.setSubject(subject);
		message.setText(text);

		mailSender.send(message);
	}
}

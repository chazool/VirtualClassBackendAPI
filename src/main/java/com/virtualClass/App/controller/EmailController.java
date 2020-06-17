package com.virtualClass.App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private JavaMailSender javaMailSender;
	
	@PostMapping("sendEmail")
	public void sendEmail() {
		 SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo("chazoolkaweesha@gmail.com");

	        msg.setSubject("Login Details");
	        msg.setText("Test Text Body");

	        javaMailSender.send(msg);
	}
	
	
}

package com.java;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailSent {

	public static void main(String[] args) throws EmailException {
		System.out.println("==========Test started========");
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("ashwinirathod12345@gmail.com", "ashwiniratho@28"));
		email.setSSLOnConnect(true);
		email.setFrom("poojaBshekar@gmail.com");
		email.setSubject("Selenium Test Report");
		email.setMsg("This is a test mail from selenium)");
		email.addTo("mukeshotwani@learn-automation.com");
		email.send();
		
		 System.out.println("=========EmailSent=========");
	}
	
}

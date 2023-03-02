package com.eminanceinnovation.service;

import java.util.Properties;
import org.springframework.stereotype.Service;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	public boolean sendEmail(String subject, String message, String to) {
		
		boolean f=false;
		
		String from="bhabani.eminenceinnovation@gmail.com";
			
		String host="smtp.gmail.com";
		
		Properties properties= new Properties();
		properties.put("mail.smtp.host",host);
		properties.put("mail.smtp.port","587");
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.auth","true");
		
		String username="";
		String password="";
		
	Session session = Session.getInstance(properties, new Authenticator() {

		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
		}
		
	});
		try {
			MimeMessage m=new MimeMessage(session);
			m.setFrom(new InternetAddress(from));
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			m.setSubject(subject);
			m.setContent(message,"text/html");
			Transport.send(m);
			f=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;	
	}
}

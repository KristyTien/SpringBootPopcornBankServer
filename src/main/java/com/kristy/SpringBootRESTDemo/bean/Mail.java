package com.kristy.SpringBootRESTDemo.bean;

import java.util.Date;
import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
	public static void send(String registermail, String body) {
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		Properties props = System.getProperties();
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.smtp.socketFactory.callback", "false");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.auth", "true");
		final String username = "kristy4500@gmail.com";
		final String password = "T2ien444K";
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("kristy4500@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(registermail));
			message.setSubject("Thank you for Choosing Flushing Bank");
			message.setContent(body, "text/html");
//			message.setText("Good Evening. We sinceerly thank you for choosing banking with Flushing Bank."
//					+ "/n Your checking account number is "+ checking 
//					+"/n Your saving account number is "+ saving);
			Transport.send(message);
			System.out.println("Done");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
//	public static void send( String mail ) {
//		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
//		Properties props = System.getProperties();
//		props.setProperty("mail.smtp.host", "smtp.gmail.com");
//		props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
//		props.setProperty("mail.smtp.socketFactory.callback", "false");
//		props.setProperty("mail.smtp.port", "465");
//		props.setProperty("mail.smtp.socketFactory.port", "465");
//		props.put("mail.smtp.auth", "true");
//		final String username = "kristy4500@gmail.com";
//		final String password = "T2ien444K";
//		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(username, password);
//			}
//		});
//		try {
//			Message message = new MimeMessage(session);
//			message.setFrom(new InternetAddress("kristy4500@gmail.com"));
//			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
//			message.setSubject("Thank you for choosing Flushing Bank");
//			message.setText("good evening" );
//			Transport.send(message);
//			System.out.println("Done");
//		} catch (MessagingException e) {
//			throw new RuntimeException(e);
//		}
//	}
	
	public static void send() {
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		Properties props = System.getProperties();
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.smtp.socketFactory.callback", "false");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.auth", "true");
		final String username = "kristy4500@gmail.com";
		final String password = "T2ien444K";
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("kristy4500@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("kristy4500@gmail.com"));
			message.setSubject("Testing");
			message.setText("Hello from Java mail!");
			Transport.send(message);
			System.out.println("Done");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
	


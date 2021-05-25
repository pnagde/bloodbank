package com.bloodbank.universal.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class MailService 
{
	final String fromEmail = "justsample4mail@gmail.com";
	final String password = "just@sample123";
	
	public int gen() {
	    Random r = new Random( System.currentTimeMillis() );
	    return 10000 + r.nextInt(20000);
	}
	
	public int sendVerifyLink(String toEmail,String name) throws MessagingException, UnsupportedEncodingException 
	{
		int code = gen();
		String link = "http://localhost:8080/user/verify?mail="+toEmail+""
				+ "&code="+code;
		String message = "<html>"
				+ "<body>"
				+ "	Hello <b>" + name + "</b>,<br><br>"
						+ "Thanks for Register with us. Please click on "
						+ "this Verification Link to activate your account."
						+ "<br><br>"
						+ "<a href='"+link+"'>Verify Account</a>"
				+ "</body>"
				+ "</html>";
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.port", "587"); //TLS Port
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
		
        //create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
			Session session = Session.getInstance(props, auth);
		
		  MimeMessage msg = new MimeMessage(session);
	      //set message headers
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");

	      msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-BloodBank"));

	      msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

	      msg.setSubject("Blood Bank Verification", "UTF-8");

	      msg.setContent(message, "text/html");
	      

	      msg.setSentDate(new Date());

	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
	      System.out.println("Message is ready");
    	  Transport.send(msg); 
    	  return code;
	}
}

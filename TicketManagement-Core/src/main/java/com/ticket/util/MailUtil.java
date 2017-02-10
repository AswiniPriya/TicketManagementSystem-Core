package com.ticket.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class MailUtil {
			
		private  MailUtil() {
		}


public static void sendSimpleMail(String mail,String message,int ticketId) throws EmailException{
		Email email = new SimpleEmail();

		email.setSmtpPort(465);
		
		email.setAuthenticator(new DefaultAuthenticator("ticketmanagement.aswini@gmail.com","aswiniabi"));
		email.setDebug(true);
		email.setHostName("smtp.gmail.com");
		email.setSSLOnConnect(true);
		email.setFrom("ticketmanagement.aswini@gmail.com");//Admin mail id
		email.setSubject("Ticket Management System");
		email.setMsg(message+""+ticketId);
		email.addTo(mail);
		email.setStartTLSEnabled(true);
		email.send();
		
			
		}
	}


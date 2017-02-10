package com.ticket.dao;

import com.ticket.util.MailUtil;

public class TestMailDao {
	public static void main(String[] args) {
		try {
			String emailId = "aswinisnsct@gmail.com";
			int ticketId = 10;
			MailUtil.sendSimpleMail(emailId,"Ticket Created Sucessfully.Your Ticket id is:",ticketId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

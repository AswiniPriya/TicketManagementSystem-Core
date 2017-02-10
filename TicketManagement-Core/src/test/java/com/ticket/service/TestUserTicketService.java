package com.ticket.service;

import com.ticket.exception.ServiceException;
import com.ticket.exception.ValidatorException;
//import com.ticket.exception.ValidatorException;

public class TestUserTicketService {
	public static void main(String[] args) throws ServiceException {
		UserTicketService userTicketService=new UserTicketService();
//	try {
//			userTicketService.registration("Aswini", "apriya417@gmail.com", "abi1", 986538431);
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (PersistenceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ValidatorException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//	try {
//			userTicketService.newTicket("apriya417@gmail.com", "abi1", "mobile", "camera is not working", "Finance", "LOW");
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (PersistenceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//	try {
//			userTicketService.ticketUpdate("apriya417@gmail.com", "abi1", "Camera feature is not at all opening", 10);
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (PersistenceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		

		
		
//		try {
//			userTicketService.ticketClose("apriya417@gmail.com", "abi1", 10);
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (PersistenceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		}
//		
	
		try {
			userTicketService.viewTicket("apriya417@gmail.com","abi1");
		} catch (ValidatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
}
package com.ticket.service;

import com.ticket.exception.PersistenceException;
import com.ticket.exception.ServiceException;
//import com.ticket.exception.ValidatorException;

public class TestEmployeeTicketService {
public static void main(String[] args){
		EmployeeService employeeService=new EmployeeService();
//	try {
//		employeeService.registration("Aswini", "apriya417@gmail.com", "abi1",1,1);
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
//	
	
	
	
//	try {
//		employeeService.ticketReassignment("abi@gmail.com", "abi", 10, 6);
//	} catch (ServiceException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (PersistenceException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//	try {
//		employeeService.updateTicket("ap@gmail.com", "lk", 10, "INPROGRESS");
//	} catch (ServiceException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (PersistenceException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	
//	try {
//		employeeService.updateSolution("priya@gmail.com", "aswini", 9, "Reboot it");
//	} catch (ServiceException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (PersistenceException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
try {
		employeeService.deleteTicket("op@gmail.com", "op", 10);
	} catch (ServiceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (PersistenceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}

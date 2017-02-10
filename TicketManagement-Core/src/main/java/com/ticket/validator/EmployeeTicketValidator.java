package com.ticket.validator;

import com.ticket.exception.ValidatorException;
import com.ticket.util.Validator;

public class EmployeeTicketValidator {
Validator validator=new Validator();
	
	public void ticketReassignment(String emailId,String password,int ticketId,int employeeId) throws ValidatorException{
		validator.validateInputString(emailId, "Email Id");
		validator.validateInputString(password, "Password");
		validator.validateInputInteger(ticketId, "Ticket Id");
		validator.validateInputInteger(employeeId, "Employee Id");
	}
	
	public void updateTicket(String emailId,String password,int ticketId,String status) throws ValidatorException{
		validator.validateInputString(emailId, "Email Id");
		validator.validateInputString(password, "Password");
		validator.validateInputInteger(ticketId, "Ticket Id");
		validator.validateInputString(status, "STATUS");
	}
	
	public void showEmployeeTicket(String emailId,String password) throws ValidatorException{
		validator.validateInputString(emailId, "Email Id");
		validator.validateInputString(password, "Password");

	}
	public void updateSolution(String emailId,String password,int ticketId,String solutionText) throws ValidatorException{
		validator.validateInputString(emailId, "Email Id");
		validator.validateInputString(password, "Password");
		validator.validateInputInteger(ticketId, "Ticket Id");
		validator.validateInputString(solutionText, "SOLUTION");

	}
	public void deleteTicket(String emailId,String password,int ticketId) throws ValidatorException{
		validator.validateInputString(emailId, "Email Id");
		validator.validateInputString(password, "Password");
		validator.validateInputInteger(ticketId, "Ticket Id");
		}
}

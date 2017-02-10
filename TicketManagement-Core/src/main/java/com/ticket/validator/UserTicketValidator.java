package com.ticket.validator;

import com.ticket.exception.ValidatorException;
import com.ticket.util.Validator;

public class UserTicketValidator {
	Validator validator = new Validator();

	public void registration(String name, String emailId, String password, Integer mobileNumber)
			throws ValidatorException {

		validator.validateInputString(name, "Name");
		validator.validateInputString(emailId, "Email Id");
		validator.validateInputString(password, "Password");
		validator.validateInputInteger(mobileNumber, "Mobile Number");
	}

	public void newTicket(String emailId, String password, String subject, String description, String department,
			String priority) throws ValidatorException {

		validator.validateInputString(emailId, "Email Id");
		validator.validateInputString(password, "Password");
		validator.validateInputString(subject, "Subject");
		validator.validateInputString(description, "Description");
		validator.validateInputString(department, "Department");
		validator.validateInputString(priority, "Priority");
	}

	public void updateTicket(String emailId, String password, int ticketId, String updateDescription)
			throws ValidatorException {

		validator.validateInputString(emailId, "Email Id");
		validator.validateInputString(password, "Password");
		validator.validateInputInteger(ticketId, "Issue Id");
		validator.validateInputString(updateDescription, "Description");
	}

	public void updateClose(String emailId, String password, int issueId) throws ValidatorException {

		validator.validateInputString(emailId, "Email Id");
		validator.validateInputString(password, "Password");
		validator.validateInputInteger(issueId, "ISSUE_ID");

	}

	public void viewTicket(String emailId,String password) throws ValidatorException{
		validator.validateInputString(emailId, "Email Id");
		validator.validateInputString(password, "Password");
		
	}
}
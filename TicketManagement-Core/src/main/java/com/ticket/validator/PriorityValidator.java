package com.ticket.validator;

import com.ticket.exception.ValidatorException;
import com.ticket.model.Priority;
import com.ticket.util.Validator;

public class PriorityValidator {
	Validator validator=new Validator();
	public void save(Priority priority) throws ValidatorException{
		validator.validateInputInteger(priority.getId(), "Id");
		validator.validateInputString(priority.getPriority(), "Priority");
		
}
}

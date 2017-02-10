package com.ticket.validator;

import com.ticket.exception.ValidatorException;
import com.ticket.model.User;
import com.ticket.util.Validator;

public class UserValidator {
	Validator validator=new Validator();
	public void save(User user) throws ValidatorException{
		validator.validateInputInteger(user.getUserId(), "User Id");
		validator.validateInputLong(user.getMobileNumber(), "Mobile Number");
		validator.validateInputString(user.getEmailId(),"Email Id");
		validator.validateInputString(user.getName(),"Name");
		validator.validateInputString(user.getPassword(),"Password");
}
}

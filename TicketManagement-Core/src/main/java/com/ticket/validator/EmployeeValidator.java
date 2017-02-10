package com.ticket.validator;

import com.ticket.exception.ValidatorException;
import com.ticket.model.Employee;
import com.ticket.util.Validator;

public class EmployeeValidator {
	Validator validator=new Validator();
	public void save(Employee employee) throws ValidatorException{
		validator.validateInputString(employee.getName(), "Name");
		validator.validateInputString(employee.getEmailId(),"Email Id");
		validator.validateInputString(employee.getPassword(),"Password");
		validator.validateInputInteger(employee.getEmployeeId(), "Employee Id");
		validator.validateInputInteger(employee.getDepartmentId().getDepartmentId(), "Department Id");
		validator.validateInputInteger(employee.getRoleId().getId(), "Employee Id");
}

}

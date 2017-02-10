package com.ticket.validator;

import com.ticket.exception.ValidatorException;
import com.ticket.model.Department;
import com.ticket.util.Validator;

public class DepartmentValidator {


Validator validator=new Validator();
public void save(Department department) throws ValidatorException{
	validator.validateInputString(department.getName(), "Name");
	validator.validateInputInteger(department.getDepartmentId(), "Id");
}

public void updateName(Department department) {
	
}

}
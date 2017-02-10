package com.ticket.util;

import java.time.LocalDateTime;

import com.ticket.exception.ValidatorException;

public class Validator {
	
	public void validateInputString(String input, String message) throws ValidatorException {
		if (input == null || "".equals(input.trim())) {
			throw new ValidatorException("Invalid " + message);
		}
	}

	public void validateInputInteger(Integer input, String message) throws ValidatorException {
		if (input == null || "".equals(input)|| " ".equals(input) || input <= 0) {
			throw new ValidatorException("Invalid " + message);
		}
	}
	
	public void validateInputLong(Long input, String message) throws ValidatorException {
		if (input == null || "".equals(input)|| " ".equals(input) || input <= 0) {
			throw new ValidatorException("Invalid " + message);
		}
	}
	
	public void validInputDate(LocalDateTime Timestamp,String message) throws ValidatorException{
		if(Timestamp==null || "".equals(Timestamp) || " ".equals(Timestamp) || Timestamp.isBefore(LocalDateTime.now())){
			throw new ValidatorException("Inavlid "+message);
		}
	
	
	}}

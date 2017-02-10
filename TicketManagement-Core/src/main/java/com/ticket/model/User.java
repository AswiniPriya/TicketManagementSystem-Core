package com.ticket.model;

import lombok.Data;

@Data
public class User {
	private int userId;
	private String name;
	private String emailId;
	private String password;
	private Long mobileNumber;
	private Boolean active;
}

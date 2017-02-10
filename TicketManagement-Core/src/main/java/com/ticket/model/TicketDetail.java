package com.ticket.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TicketDetail {
	private int id;
	private User userId;
	private Department departmentId;
	private String subject;
	private String description;
	private Priority priority;
	private LocalDateTime createdDate;
	private Employee employeeId;
	private LocalDateTime closedDate;
	private String status;
}

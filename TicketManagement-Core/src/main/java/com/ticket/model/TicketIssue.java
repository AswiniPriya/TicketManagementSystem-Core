package com.ticket.model;

import lombok.Data;

@Data
public class TicketIssue {

	private int id;
	private TicketDetail ticketId;
	private String solution;
}

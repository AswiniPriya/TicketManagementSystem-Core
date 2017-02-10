package com.ticket.dao;

import java.util.Iterator;
import java.util.List;

//import com.ticket.model.TicketDetail;
import com.ticket.model.TicketIssue;

public class TestTicketIssueDao {
	public static void main(String[] args) {
		TicketIssueDao ticketIssueDao = new TicketIssueDao();
		
	//TicketIssue ticketIssue = new TicketIssue();
		
		//ticketIssue.setId(2);
		
	//TicketDetail ticketDetail = new TicketDetail();
//		ticketDetail.setId(1);
//		ticketIssue.setTicketId(ticketDetail);
//
//		ticketIssue.setSolution("Yes solution");
//		//ticketIssueDao.save(ticketIssue);
//		
//		ticketIssueDao.updateSolution(ticketIssue);
	//	ticketIssueDao.delete(1);
	
	List<TicketIssue> list = ticketIssueDao.list();
	Iterator<TicketIssue> i = list.iterator();
	while (i.hasNext()) {
		TicketIssue ticketIssue = (TicketIssue) i.next();
		System.out.println(ticketIssue.getId() + "\t" + ticketIssue.getTicketId().getId() + "\t"
				+ ticketIssue.getSolution());
	}
	}

}

package com.ticket.dao;

import java.util.List;

import com.ticket.model.Employee;
import com.ticket.model.TicketDetail;
import com.ticket.model.TicketIssue;

public class EmployeeTicketDao {

	TicketDetailDao ticketDetailDao=new TicketDetailDao();
	 TicketIssueDao ticketIssueDao=new TicketIssueDao();
		

		public void reassignTicket(TicketDetail ticketDetail) {

			ticketDetailDao.ticketReassign(ticketDetail);

		}

		public List<TicketDetail> viewEmployeeTicket(Employee employee) {
			List<TicketDetail> list = ticketDetailDao.selectByEmployeeId(employee);
			return list;
			
		
		}

		public void solutionUpdate(TicketIssue ticketIssue, TicketDetail ticketDetail) {

			ticketIssueDao.updateSolution(ticketIssue);
		}


}

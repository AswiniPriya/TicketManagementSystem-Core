package com.ticket.dao;

import java.util.List;
import java.util.logging.Logger;

import com.ticket.model.Department;
import com.ticket.model.Priority;
import com.ticket.model.TicketDetail;
import com.ticket.model.User;

public class UserTicketDao {
	TicketDetailDao ticketDetailDao = new TicketDetailDao();
	TicketDetail ticketDetail = new TicketDetail();
	UserDao userDao = new UserDao();

	public void newTicket(User userId, Department departmentId, String subject, String description, Priority priority) {
		ticketDetail.setUserId(userId);
		ticketDetail.setDepartmentId(departmentId);
		ticketDetail.setSubject(subject);
		ticketDetail.setDescription(description);
		ticketDetail.setPriority(priority);
		ticketDetailDao.save(ticketDetail);

	}

	public void updateTicket(int id, User userId, String description) {
		// if((ticketDetailDao.findUserStatus(id,userId)).getStatus()!="CLOSED")
		// {
		ticketDetail.setDescription(description);
		ticketDetail.setId(id);
		ticketDetail.setUserId(userId);
		ticketDetailDao.updateDescription(ticketDetail);
		// }
	}

	public List<TicketDetail> viewTicket(int userId) {
		Logger logger = Logger.getLogger(UserTicketDao.class.getName());
		List<TicketDetail> list = ticketDetailDao.listByUserId(userId);
		for (TicketDetail ticketDetail : list) {
			logger.info(ticketDetail.getId() + "\t" + ticketDetail.getSubject() + "\t" + ticketDetail.getDescription()
					+ "\t" + ticketDetail.getCreatedDate() + "\t" + ticketDetail.getStatus());
		}
		return list;
	}

	public void closeTicket(int id, User userId) {
		if (ticketDetailDao.findUserStatus(id, userId).getStatus() != "CLOSED") {
			ticketDetail.setStatus("CLOSED");
			ticketDetail.setId(id);
			ticketDetail.setUserId(userId);
			ticketDetailDao.close(ticketDetail);
		}

	}

}
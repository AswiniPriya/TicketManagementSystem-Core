package com.ticket.service;

import java.util.List;

import com.ticket.dao.DepartmentDao;
import com.ticket.dao.LoginDao;
import com.ticket.dao.PriorityDao;
import com.ticket.dao.TicketDetailDao;
import com.ticket.dao.TicketIssueDao;
import com.ticket.dao.UserDao;
import com.ticket.dao.UserTicketDao;
import com.ticket.exception.PersistenceException;
import com.ticket.exception.ServiceException;
import com.ticket.exception.ValidatorException;
import com.ticket.model.Department;
import com.ticket.model.Employee;
import com.ticket.model.Priority;
import com.ticket.model.TicketDetail;
import com.ticket.model.TicketIssue;
import com.ticket.model.User;
import com.ticket.util.MailUtil;
import com.ticket.validator.UserTicketValidator;

public class UserTicketService {
	TicketDetail ticketDetail = new TicketDetail();
	User user = new User();
	Department department = new Department();
	Employee employee = new Employee();
	Priority priority = new Priority();
	TicketIssue ticketIssue = new TicketIssue();
	UserDao userDao = new UserDao();
	TicketIssueDao ticketIssueDao = new TicketIssueDao();
	TicketDetailDao ticketDetailDao = new TicketDetailDao();
	LoginDao loginDao = new LoginDao();
	DepartmentDao departmentDao = new DepartmentDao();
	PriorityDao priorityDao = new PriorityDao();
	UserTicketValidator userTicketValidator = new UserTicketValidator();
	UserTicketDao userTicketDao = new UserTicketDao();

	public void registration(String name, String emailId, String password, long mobileNumber)
			throws ServiceException, PersistenceException, ValidatorException {

		user.setName(name);
		user.setEmailId(emailId);
		user.setPassword(password);
		user.setMobileNumber(mobileNumber);
		userDao.save(user);
	}

	public void newTicket(String emailId, String password, String subject, String description, String departmentName,
			String priorityName) throws ServiceException, PersistenceException {
		try {
			user.setEmailId(emailId);
			user.setPassword(password);
			userTicketValidator.newTicket(emailId, password, subject, description, departmentName, priorityName);
			if (loginDao.login(emailId, password)) {
				int userId = userDao.findUserId(emailId).getUserId();
				user.setUserId(userId);
				int departmentId = departmentDao.findDepartmentId(departmentName).getDepartmentId();
				department.setDepartmentId(departmentId);
				int priorityId = priorityDao.findPriorityId(priorityName).getId();
				priority.setId(priorityId);
				switch (departmentId) {
				case 1:
					employee.setEmployeeId(1);
					break;
				case 2:
					employee.setEmployeeId(2);
					break;
				}

				userTicketDao.newTicket(user, department, subject, description, priority);
				int ticketId = ticketDetailDao.findTicketId(user).getId();
				ticketDetail.setId(ticketId);
				ticketIssueDao.save(ticketDetail);
				try {
					MailUtil.sendSimpleMail(emailId,"Ticket Created for user id "+userId+" Ticket id is:",ticketId);
				} catch (Exception e) {

				}
			}

		} catch (ValidatorException e) {
			throw new ServiceException("Cannot Create Ticket", e);
		}
	}

	public void ticketUpdate(String emailId, String password, String description, int ticketId)
			throws ServiceException, PersistenceException {
		try {
			user.setEmailId(emailId);
			user.setPassword(password);
			userTicketValidator.updateTicket(emailId, password, ticketId, description);
			if (loginDao.login(emailId, password)) {
				int userId = userDao.findUserId(emailId).getUserId();
				user.setUserId(userId);
				if (ticketDetailDao.findUserStatus(ticketId, user).getStatus() != "Closed") {
					userTicketDao.updateTicket(ticketId, user, description);
				}
			}
		} catch (ValidatorException e) {
			throw new ServiceException("Cannot Update Ticket", e);
		}
	}

	public void ticketClose(String emailId, String password, int ticketId)
			throws ServiceException, PersistenceException {
		try {
			user.setEmailId(emailId);
			user.setPassword(password);
			userTicketValidator.updateClose(emailId, password, ticketId);
			if (loginDao.login(emailId, password)) {
				int userId = userDao.findUserId(emailId).getUserId();
				user.setUserId(userId);
				if ((ticketDetailDao.findUserStatus(ticketId, user)).getStatus() != "Closed") {
					userTicketDao.closeTicket(ticketId, user);
				}
			}
		} catch (ValidatorException e) {
			throw new ServiceException("Cannot Close Ticket", e);
		}

	}

	public List<TicketDetail> viewTicket(String emailId, String password) throws ValidatorException {
		user.setEmailId(emailId);
		user.setPassword(password);
		userTicketValidator.viewTicket(emailId, password);
		if (loginDao.login(emailId, password)) {
			UserDao userDao = new UserDao();
			return userTicketDao.viewTicket(userDao.userId(emailId, password));
		}
		return null;
	}

}



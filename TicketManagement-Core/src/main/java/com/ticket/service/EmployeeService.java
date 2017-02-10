package com.ticket.service;

import java.util.List;

import com.ticket.dao.DepartmentDao;
import com.ticket.dao.EmployeeDao;
import com.ticket.dao.EmployeeTicketDao;
import com.ticket.dao.LoginDao;
import com.ticket.dao.PriorityDao;
import com.ticket.dao.TicketDetailDao;
import com.ticket.dao.UserTicketDao;
import com.ticket.exception.PersistenceException;
import com.ticket.exception.ServiceException;
import com.ticket.exception.ValidatorException;
import com.ticket.model.Department;
import com.ticket.model.Employee;
import com.ticket.model.Priority;
import com.ticket.model.Role;
import com.ticket.model.TicketDetail;
import com.ticket.model.TicketIssue;
import com.ticket.validator.EmployeeTicketValidator;

public class EmployeeService {
	TicketDetail ticketDetail=new TicketDetail();
	Department department=new Department();
	Employee employee=new Employee();
	Priority priority=new Priority();
	TicketIssue ticketIssue=new TicketIssue();
	EmployeeDao employeeDao=new EmployeeDao();
	TicketDetailDao ticketDetailDao=new TicketDetailDao();
	LoginDao loginDao=new LoginDao();
	DepartmentDao departmentDao=new DepartmentDao();
	PriorityDao priorityDao=new PriorityDao();
	EmployeeTicketValidator employeeTicketValidator=new EmployeeTicketValidator();
	EmployeeTicketDao employeeTicketDao=new EmployeeTicketDao();
	UserTicketDao userTicketDao=new UserTicketDao();
	Role role=new Role();
	
public void registration(String name,String emailId,String password,int departmentId,int roleId) throws ServiceException,PersistenceException, ValidatorException{
		
		employee.setName(name);
		employee.setEmailId(emailId);
		employee.setPassword(password);
		department.setDepartmentId(departmentId);
		employee.setDepartmentId(department);
		role.setId(roleId);
		employee.setRoleId(role);
		employeeDao.save(employee);
	}
	
	
	public void ticketReassignment(String emailId,String password,int ticketId,int employeeId) throws ServiceException, PersistenceException{
		
		try {
			employeeTicketValidator.ticketReassignment(emailId, password, ticketId, employeeId);
			if(loginDao.employeelogin(emailId, password))
			{
				int id=employeeDao.findEmployeeId(emailId).getEmployeeId();
				if(id!=employeeId)	
				{
					int existingEmployee=(employeeDao.findEmployeeDepartmentId(id).getDepartmentId().getDepartmentId());
					int newEmployee=(employeeDao.findEmployeeDepartmentId(employeeId).getDepartmentId().getDepartmentId());
					if(existingEmployee==newEmployee)
					{
						if(newEmployee==(ticketDetailDao.findDepartmentId(ticketId).getDepartmentId().getDepartmentId())){
					ticketDetail.setId(ticketId);
					employee.setEmployeeId(employeeId);
					ticketDetail.setEmployeeId(employee);
					employeeTicketDao.reassignTicket(ticketDetail);
					}
					}
				}
			}
			}catch (ValidatorException e) {
				throw new ServiceException("Cannot Reassign Ticket", e);
			}
		
	}
	
	public void updateTicket(String emailId,String password,int ticketId,String status) throws ServiceException, PersistenceException{
		
		try {
			employeeTicketValidator.updateTicket(emailId, password, ticketId, status);
			if(loginDao.employeelogin(emailId, password))
			{
				int employeeId=employeeDao.findEmployeeId(emailId).getEmployeeId();
				if(employeeId==(ticketDetailDao.findEmployeeId(ticketId).getEmployeeId().getEmployeeId())){
					ticketDetail.setId(ticketId);
					employee.setEmployeeId(employeeId);
					ticketDetail.setEmployeeId(employee);
					ticketDetail.setStatus(status);
					ticketDetailDao.employeeUpdate(ticketDetail);
				}
				}
			}catch (ValidatorException e) {
				throw new ServiceException("Cannot Update Ticket", e);
			}
			
		
	}
	
	public void updateSolution(String emailId,String password,int ticketId,String solutionText) throws ServiceException, PersistenceException{
		try {
			employeeTicketValidator.updateSolution(emailId, password, ticketId, solutionText);
			if(loginDao.employeelogin(emailId, password))
			{
				int employeeId=employeeDao.findEmployeeId(emailId).getEmployeeId();
				if(employeeId==(ticketDetailDao.findEmployeeId(ticketId).getEmployeeId().getEmployeeId())){
				ticketDetail.setId(ticketId);
				ticketIssue.setTicketId(ticketDetail);
				ticketIssue.setSolution(solutionText);
				employeeTicketDao.solutionUpdate(ticketIssue,ticketDetail);
				}
				}
			}catch (ValidatorException e) {
				throw new ServiceException("Cannot Update Solution", e);
			}
	}
	
	public List<TicketDetail> showEmployeeTicket(String emailId,String password)throws ValidatorException, ServiceException
	{
		
			employeeTicketValidator.showEmployeeTicket(emailId, password);
			if(loginDao.employeelogin(emailId, password))
			{
			int employeeId=employeeDao.findEmployeeId(emailId).getEmployeeId();
			employee.setEmployeeId(employeeId);
			return employeeTicketDao.viewEmployeeTicket(employee);
			}
			
		return null;
	}
	
	public void deleteTicket(String emailId,String password,int ticketId) throws ServiceException, PersistenceException{
		
		try {
			employeeTicketValidator.deleteTicket(emailId, password, ticketId);
			if(loginDao.employeelogin(emailId, password))
			{
			int employeeId=employeeDao.findEmployeeId(emailId).getEmployeeId();
			if((employeeDao.findEmployeeRoleId(employeeId).getRoleId().getId())==2){
				int existingEmployee=(employeeDao.findEmployeeDepartmentId(employeeId).getDepartmentId().getDepartmentId());
				if(existingEmployee==(ticketDetailDao.findDepartmentId(ticketId).getDepartmentId().getDepartmentId())){
					ticketDetailDao.deleteIssue(ticketId);
				ticketDetailDao.delete(ticketId);
				}
			}
			}
			} catch (ValidatorException e) {
				throw new ServiceException("Cannot Delete Ticket", e);
			}

	}
}

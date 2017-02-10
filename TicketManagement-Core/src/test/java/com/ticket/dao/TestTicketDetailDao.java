package com.ticket.dao;

//import java.util.Iterator;
//import java.util.List;

//import com.ticket.model.Department;
//import com.ticket.model.Employee;
//import com.ticket.model.Priority;
import com.ticket.model.TicketDetail;
import com.ticket.model.User;

public class TestTicketDetailDao {

	public static void main(String[] args) {

		TicketDetailDao ticketDetailDao = new TicketDetailDao();

		TicketDetail ticketDetail = new TicketDetail();
		//ticketDetail.setId(2);
		User user = new User();
		user.setUserId(1);
		//ticketDetail.setUserId(user);
//		// Department department = new Department();
		// department.setDepartmentId(1);
		// ticketDetail.setDepartmentId(department);
		// ticketDetail.setSubject("Mobile");
		// ticketDetail.setDescription("Specification not working");
		// Priority priority=new Priority();
		// priority.setId(1);
		// ticketDetail.setPriority(priority);
		// ticketDetailDao.save(ticketDetail);

		// Employee employee=new Employee();
		// employee.setEmployeeId(1);
		// ticketDetail.setEmployeeId(employee);
		// ticketDetail.setId(4);
		ticketDetailDao.update(ticketDetail);
		//
		// ticketDetailDao.delete(4);
		//
//		 List<TicketDetail> list = ticketDetailDao.selectByEmployeeId(employee)
//		 Iterator<TicketDetail> i = list.iterator();
//		 while (i.hasNext()) {
//		 TicketDetail ticketDetail = (TicketDetail) i.next();
//		 System.out.println(ticketDetail.getId() + "\t" +
//		 ticketDetail.getUserId().getUserId() + "\t"
//		 + ticketDetail.getDepartmentId().getDepartmentId() + "\t" +
//		 ticketDetail.getSubject() + "\t"
//		 + ticketDetail.getDescription() + "\t" +
//		 ticketDetail.getPriority().getId() + "\t"
//		 + ticketDetail.getEmployeeId().getEmployeeId() + "\t" +
//		 ticketDetail.getCreatedDate() + "\t"
//		 + ticketDetail.getClosedDate() + "\t" + ticketDetail.getStatus());
//		 }
//		
		
			}
}
package com.ticket.dao;

//import com.ticket.model.TicketDetail;
//import com.ticket.model.Department;
import com.ticket.model.User;

public class TestUserTicketDao {

	public static void main(String[] args) {
			
		UserTicketDao userTicketDao = new UserTicketDao();
		User user = new User();
		user.setUserId(1);
//		Department department=new Department();
//		department.setDepartmentId(2);
//		
//		Priority priority=new Priority();
//		priority.setId(1);
		//userTicketDao.newTicket(user, department, "Laptop", "Laptop is funtioning properly according to specificaion", priority);
		
	//	userTicketDao.updateTicket(7, user,"Laptop is not funtioning properly according to specification");
	
		userTicketDao.viewTicket(1);
		
//		List<TicketDetail> list = userTicketDao.viewTicket(user);
//		 Iterator<TicketDetail> i = list.iterator();
//		 while (i.hasNext()) {
//		 TicketDetail ticketDetail = (TicketDetail) i.next();
//		 System.out.println(ticketDetail.getId() + "\t" +
//		 ticketDetail.getUserId().getUserId() + "\t"
//		 + ticketDetail.getDepartmentId().getDepartmentId() + "\t" +
//		 ticketDetail.getSubject() + "\t"
//		 + ticketDetail.getDescription() + "\t" +
//		 ticketDetail.getPriority().getId() + "\t"+
//		 ticketDetail.getCreatedDate()+ "\t" + 
//		 
//		 + ticketDetail.getEmployeeId().getEmployeeId() + "\t"+
//		 ticketDetail.getStatus());
		 }

		//userTicketDao.closeTicket(7, user);
		
		 

	}

	



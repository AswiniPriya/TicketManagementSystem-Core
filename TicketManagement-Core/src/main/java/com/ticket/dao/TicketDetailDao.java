package com.ticket.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ticket.model.Department;
import com.ticket.model.Employee;
import com.ticket.model.Priority;
import com.ticket.model.TicketDetail;
import com.ticket.model.User;
import com.ticket.util.ConnectionUtil;

public class TicketDetailDao {

JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	
	public void save(TicketDetail ticketDetail) {
		String sql = "INSERT INTO tbl_ticket_details(user_id,department_id,subject,description,priority) VALUES(?,?,?,?,?)";
		Object[] params={ticketDetail.getUserId().getUserId(),ticketDetail.getDepartmentId().getDepartmentId(),ticketDetail.getSubject(),ticketDetail.getDescription(),ticketDetail.getPriority().getId()};
		jdbcTemplate.update(sql, params);

	}
	
	public void update(TicketDetail ticketDetail) {

		String sql = "UPDATE tbl_ticket_details SET status=? WHERE id=? AND user_id=?";
		Object[] params={ ticketDetail.getStatus(),ticketDetail.getId(),ticketDetail.getUserId().getUserId()};
		jdbcTemplate.update(sql, params);

	}

	public void updateDescription(TicketDetail ticketDetail) {

		String sql = "UPDATE tbl_ticket_details SET description=? WHERE id=? AND user_id=?";
		Object[] params={ ticketDetail.getDescription(),ticketDetail.getId(),ticketDetail.getUserId().getUserId()};
		jdbcTemplate.update(sql, params);

	}
	
	public void delete(int id) {

		String sql = "DELETE FROM tbl_ticket_details WHERE id=?";
		jdbcTemplate.update(sql, id);
		
	}

	public void deleteIssue(int id) {

		String sql = "DELETE FROM tbl_ticket_issues WHERE ticket_id=?";
		jdbcTemplate.update(sql, id);
		
	}
	
		
//		public List<TicketDetail> selectAll() {
//
//			String sql = "SELECT id,user_id,department_id,subject,description,priority,created_date,employee_id,status FROM tbl_ticket_details";
//			Object[] params={};
//			return convert(sql,params);
//
//	}
		
		public TicketDetail findUserStatus(int id,User userId)
		{
			String sql = "SELECT status FROM tbl_ticket_details WHERE id=? AND user_id=?";
			Object[] params={id,userId.getUserId()};
			return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
				TicketDetail ticketDetail=new TicketDetail();
				ticketDetail.setStatus(rs.getString("status"));
				return ticketDetail;
			});

		}
		
		
		
		public List<TicketDetail> listByUserId(int Userid){
			
				String sql = "SELECT id,subject,description,created_date,status FROM tbl_ticket_details WHERE user_id=?";
				Object[] params={Userid};		
				return jdbcTemplate.query(sql,params, (rs, rowNo) -> {
					TicketDetail ticketDetail=new TicketDetail();
					ticketDetail.setId(rs.getInt("id"));
					
//					User user=new User();
//					user.setUserId(rs.getInt("user_id"));
//					ticketDetail.setUserId(user);
//					
//					Department department=new Department();
//					department.setDepartmentId(rs.getInt("department_id"));
//					ticketDetail.setDepartmentId(department);
//					
					ticketDetail.setSubject(rs.getString("subject"));
					ticketDetail.setDescription(rs.getString("description"));
//					Priority priority=new Priority();
//					priority.setId(rs.getInt("priority"));
//					ticketDetail.setPriority(priority);
					ticketDetail.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());

//					Employee employee=new Employee();
//					employee.setEmployeeId(rs.getInt("employee_id"));
//					ticketDetail.setEmployeeId(employee);
//					
					
					ticketDetail.setStatus(rs.getString("status"));
					return ticketDetail;

				});
			
		}		
		public void close(TicketDetail ticketDetail){
			
			String sql = "UPDATE tbl_ticket_details SET STATUS=?,closed_date=CURRENT_TIMESTAMP() WHERE USER_ID=? AND ID=?";
			Object[] params={ ticketDetail.getStatus(),ticketDetail.getUserId().getUserId(),ticketDetail.getId()};
			jdbcTemplate.update(sql, params);

		}


			public List<TicketDetail> selectByEmployeeId(Employee employee) {

			String sql = "SELECT id,user_id,department_id,subject,description,priority,created_date,employee_id,status FROM tbl_ticket_details WHERE employee_id=?";
			Object[] params={employee.getEmployeeId()};
			return jdbcTemplate.query(sql,params, (rs, rowNo) -> {
			
			TicketDetail ticketDetail=new TicketDetail();
			ticketDetail.setId(rs.getInt("id"));
			
			User user=new User();
			user.setUserId(rs.getInt("user_id"));
			ticketDetail.setUserId(user);
			
			Department department=new Department();
			department.setDepartmentId(rs.getInt("department_id"));
			ticketDetail.setDepartmentId(department);
			
			ticketDetail.setSubject(rs.getString("subject"));
			ticketDetail.setDescription(rs.getString("description"));
			Priority priority=new Priority();
			priority.setId(rs.getInt("priority"));
			ticketDetail.setPriority(priority);
			ticketDetail.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());

			employee.setEmployeeId(rs.getInt("employee_id"));
			ticketDetail.setEmployeeId(employee);
			
			
			ticketDetail.setStatus(rs.getString("status"));
			return ticketDetail;
			});


	}
			
//			private List<TicketDetail> convert(String sql, Object[] params) {
//			return (List<TicketDetail>) jdbcTemplate.query(sql,params, (rs, rowNum) -> {
//				
//				TicketDetail ticketDetail=new TicketDetail();
//				ticketDetail.setId(rs.getInt("id"));
//				
//				User user=new User();
//				user.setUserId(rs.getInt("user_id"));
//				ticketDetail.setUserId(user);
//				
//				Department department=new Department();
//				department.setDepartmentId(rs.getInt("department_id"));
//				ticketDetail.setDepartmentId(department);
//				
//				ticketDetail.setSubject(rs.getString("subject"));
//				ticketDetail.setDescription(rs.getString("description"));
//				Priority priority=new Priority();
//				priority.setId(rs.getInt("priority"));
//				ticketDetail.setPriority(priority);
//				ticketDetail.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());
//
//				Employee employee=new Employee();
//				employee.setEmployeeId(rs.getInt("employee_id"));
//				ticketDetail.setEmployeeId(employee);
//				
//				
//				ticketDetail.setStatus(rs.getString("status"));
//				return ticketDetail;
//
//			});
//		}
		
		public void employeeUpdate(TicketDetail ticketDetail){
			
			String sql="UPDATE tbl_ticket_details SET status=? WHERE id=? AND employee_id=?";
			Object[] params={ticketDetail.getStatus(),ticketDetail.getId(),ticketDetail.getEmployeeId().getEmployeeId()};
			jdbcTemplate.update(sql,params);
			
		}
		
		public void ticketReassign(TicketDetail ticketDetail){

			String sql="UPDATE tbl_ticket_details SET employee_id=?,status='In Progress' WHERE id=?";
			Object[] params={ticketDetail.getEmployeeId().getEmployeeId(),ticketDetail.getId()};
			jdbcTemplate.update(sql, params);
		}
		
		
		public TicketDetail findTicketId(User userId)
		{
			String sql = "SELECT id FROM tbl_ticket_details WHERE user_id=? ORDER BY id DESC LIMIT 1";
			Object[] params={userId.getUserId()};
			return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
				TicketDetail ticketDetail=new TicketDetail();
				ticketDetail.setId(rs.getInt("id"));;
				return ticketDetail;
			});

		}
		
		public TicketDetail findDepartmentId(int id)
		{
			String sql = "SELECT department_id FROM tbl_ticket_details WHERE id=?";
			Object[] params={id};
			return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
				TicketDetail ticketDetail=new TicketDetail();
				Department department=new Department();
				department.setDepartmentId(rs.getInt("department_id"));
				ticketDetail.setDepartmentId(department);
				return ticketDetail;
			});

		}
		
		public TicketDetail findEmployeeId(int id)
		{
			String sql = "SELECT employee_id FROM tbl_ticket_details WHERE id=?";
			Object[] params={id};
			return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
				TicketDetail ticketDetail=new TicketDetail();
				Employee employee=new Employee();
				employee.setEmployeeId(rs.getInt("employee_id"));
				ticketDetail.setEmployeeId(employee);
				return ticketDetail;
			});

	
		
		
}}
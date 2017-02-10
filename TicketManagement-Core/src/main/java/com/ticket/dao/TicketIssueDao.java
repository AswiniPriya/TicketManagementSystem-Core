package com.ticket.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ticket.model.TicketDetail;
import com.ticket.model.TicketIssue;
import com.ticket.util.ConnectionUtil;

public class TicketIssueDao {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	public void save(TicketDetail ticketDetail)
	{
		
		String sql = "insert into tbl_ticket_issues(ticket_id) values(?)";
		Object[] params = {ticketDetail.getId()  };
		jdbcTemplate.update(sql, params);
	}

	public void updateSolution(TicketIssue ticketIssue) {
		String sql = "update tbl_ticket_issues set solution=? where ticket_id=?";
		Object[] params = { ticketIssue.getSolution(), ticketIssue.getTicketId().getId() };
		jdbcTemplate.update(sql, params);
		
	}
	
	public void delete(int id) {
		String sql = "delete from tbl_ticket_issues where id=?";
		jdbcTemplate.update(sql, id);
	}

	public List<TicketIssue> list() {
		String sql = "select id,ticket_id,solution  from tbl_ticket_issues";
		return jdbcTemplate.query(sql, (rs, rowNum) -> convert(rs));
	}

	private TicketIssue convert(ResultSet rs) throws SQLException {

		TicketIssue ticketIssue = new TicketIssue();
		ticketIssue.setId(rs.getInt("id"));
		
		TicketDetail ticketDetail = new TicketDetail();
		ticketDetail.setId(rs.getInt("ticket_id"));
		ticketIssue.setTicketId(ticketDetail);
		
		
		ticketIssue.setSolution(rs.getString("solution"));
		return ticketIssue;
	}


	

}

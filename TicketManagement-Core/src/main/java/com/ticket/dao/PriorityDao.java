package com.ticket.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ticket.model.Priority;
import com.ticket.util.ConnectionUtil;

public class PriorityDao {
	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	

	public void save(Priority priority) {

		String sql = "INSERT INTO tbl_priorities(id,priority) VALUES(?,?)";
		Object[] params = {priority.getId(),priority.getPriority() };
		jdbcTemplate.update(sql, params);

	}
	
	public void update(Priority priority) {

		String sql = "UPDATE tbl_priorities SET active=? WHERE id=?";
		Object[] params = { priority.getActive(),priority.getId() };
		jdbcTemplate.update(sql, params);

	}

	public void delete(int id) {

		String sql = "DELETE FROM tbl_priorities WHERE ID=?";
		jdbcTemplate.update(sql, id);
		
	}
		
		public List<Priority> list() {

			String sql = "SELECT id,priority,active FROM tbl_priorities";
			Object[] params={};
			return convert(sql,params);

	}
		
		private List<Priority> convert(String sql, Object[] params) {
			return (List<Priority>) jdbcTemplate.query(sql,params, (rs, rowNum) -> {
				Priority priority=new Priority();
				priority.setId(rs.getInt("id"));
				priority.setPriority(rs.getString("priority"));
				priority.setActive(rs.getBoolean("active"));
				return priority;

			});
}
		public Priority findPriorityId(String priorityName) {
			String sql = "SELECT id FROM tbl_priorities WHERE priority = ?";
			Object[] params = { priorityName };
			return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
				Priority priority=new Priority();
				priority.setId(rs.getInt("id"));
				return priority;
			
			});

		}

}

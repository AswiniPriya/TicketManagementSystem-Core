package com.ticket.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ticket.model.Role;
import com.ticket.util.ConnectionUtil;

public class RoleDao {
JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	
	public void save(Role role) {

		String sql = "INSERT INTO tbl_roles(id,name) VALUES(?,?)";
		Object[] params = { role.getId(),role.getName() };
		jdbcTemplate.update(sql, params);

	}
	
	public void update(Role role) {

		String sql = "UPDATE tbl_roles SET active=? WHERE id=?";
		Object[] params = { role.getActive(),role.getId() };
		jdbcTemplate.update(sql, params);

	}

	public void delete(int id) {

		String sql = "DELETE FROM tbl_roles WHERE id=?";
		jdbcTemplate.update(sql, id);
		
	}
		
		public List<Role> list() {

			String sql = "SELECT id,name,active FROM tbl_roles";
			Object[] params={};
			return convert(sql,params);
			}

		private List<Role> convert(String sql, Object[] params) {
			return (List<Role>) jdbcTemplate.query(sql,params, (rs, rowNum) -> {
				Role role=new Role();
				role.setId(rs.getInt("id"));
				role.setName(rs.getString("name"));
				role.setActive(rs.getBoolean("active"));
				return role;

			});
	}

}

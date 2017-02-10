package com.ticket.dao;


import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ticket.model.User;
import com.ticket.util.ConnectionUtil;

public class UserDao {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	
	public void save(User user)
	{
		String sql = "insert into tbl_users(name,email_id,password,mobile_number) values(?,?,?,?)";
		Object[] params = {user.getName(),user.getEmailId(),user.getPassword(),user.getMobileNumber()};
		jdbcTemplate.update(sql, params);
	}

	public void updatePassword(User user) {
		String sql = "update tbl_users set password=? where user_id=?";
		Object[] params = { user.getPassword(), user.getUserId() };
		jdbcTemplate.update(sql, params);

	}
	public void updateMobileNumber(User user) {
		String sql = "update tbl_users set mobile_number=? where user_id=?";
		Object[] params = { user.getMobileNumber(), user.getUserId() };
	    jdbcTemplate.update(sql, params);

	}

	public void updateActive(User user) {
		String sql = "update tbl_users set active=? where user_id=?";
		Object[] params = { user.getActive(), user.getUserId() };
		jdbcTemplate.update(sql, params);

	}
	public void delete(int id) {
		String sql = "delete from tbl_users where user_id=?";
		jdbcTemplate.update(sql, id);
	}

	public List<User> list() {
		String sql = "select user_id,name,email_id,password,mobile_number,active  from tbl_users";
		List<User> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			User user = new User();
			user.setUserId(rs.getInt("user_id"));
			user.setName(rs.getString("name"));
			user.setEmailId(rs.getString("email_id"));
			user.setPassword(rs.getString("password"));
			user.setMobileNumber(rs.getLong("mobile_number"));
			user.setActive(rs.getBoolean("active"));
			return user;
		});
		return list;
	}
	public User getPassword(String emailId) {
		String sql = "SELECT password FROM tbl_users WHERE email_id=?";
		Object[] params = { emailId };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			User user = new User();
			user.setPassword(rs.getString("password"));
			return user;
		});
	}
	public User findUserId(String emailId) {
		String sql = "SELECT user_id FROM tbl_users WHERE email_id = ?";
		Object[] params = { emailId };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
			User user=new User();
			user.setUserId(rs.getInt("user_id"));
			return user;
		
		});

	}
	public int userId(String emailId, String password) {

		String sql = "select user_id from tbl_users where email_id=? and password=?";
		Object[] params={emailId,password};
		return jdbcTemplate.queryForObject(sql, params, Integer.class);	}
	
		
	
}

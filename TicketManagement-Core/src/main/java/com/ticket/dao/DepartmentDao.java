package com.ticket.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ticket.model.Department;
import com.ticket.util.ConnectionUtil;

public class DepartmentDao {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	public void save(Department department)
	{
		
		String sql = "insert into tbl_departments(department_id,name,active) values(?,?,?)";
		Object[] params = {department.getDepartmentId() , department.getName(),department.getActive() };
		jdbcTemplate.update(sql, params);
	}

	public void updateName(Department department) {
		String sql = "update tbl_departments set name=? where department_id=?";
		Object[] params = { department.getName(), department.getDepartmentId() };
		jdbcTemplate.update(sql, params);

	}
	public void updateActive(Department department) {
		String sql = "update tbl_departments set active=? where department_id=?";
		Object[] params = { department.getActive(), department.getDepartmentId() };
		jdbcTemplate.update(sql, params);

	}
	public void delete(int id) {
		String sql = "delete from tbl_departments where department_id=?";
		jdbcTemplate.update(sql, id);
	}

	public List<Department> list() {
		String sql = "select department_id,name,active  from tbl_departments";
		List<Department> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			Department department = new Department();
			department.setDepartmentId(rs.getInt("department_id"));
			department.setName(rs.getString("name"));
			department.setActive(rs.getBoolean("active"));
			return department;
		});
		return list;
	}
	public Department findDepartmentId(String departmentName) {
		String sql = "SELECT department_id FROM tbl_departments WHERE name = ?";
		Object[] params = { departmentName };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
			Department department=new Department();
			department.setDepartmentId(rs.getInt("department_id"));
			return department;
		
		});

	}


}

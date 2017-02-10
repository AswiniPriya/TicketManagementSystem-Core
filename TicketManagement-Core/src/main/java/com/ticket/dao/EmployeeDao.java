package com.ticket.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ticket.model.Department;
import com.ticket.model.Employee;
import com.ticket.model.Role;
import com.ticket.util.ConnectionUtil;

public class EmployeeDao {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Employee employee) {
		String sql = "insert into tbl_employees(department_id,role_id,name,email_id,password) values(?,?,?,?,?)";
		Object[] params = {  employee.getDepartmentId().getDepartmentId(),
				employee.getRoleId().getId(), employee.getName(), employee.getEmailId(), employee.getPassword(),
				 };
		jdbcTemplate.update(sql, params);
	}

	public void updateDepartmentId(Employee employee) {
		String sql = "update tbl_employees set department_id =? where employee_id=?";
		Object[] params = { employee.getDepartmentId().getDepartmentId(), employee.getEmployeeId() };
		jdbcTemplate.update(sql, params);

	}

	public void updateRole(Employee employee) {
		String sql = "update tbl_employees set role_id=? where employee_id=?";
		Object[] params = { employee.getRoleId().getId(), employee.getEmployeeId() };
		jdbcTemplate.update(sql, params);

	}

	public void updatePassword(Employee employee) {
		String sql = "update tbl_employees set password=? where employee_id=?";
		Object[] params = { employee.getPassword(), employee.getEmployeeId() };
		jdbcTemplate.update(sql, params);

	}

	public void updateActive(Employee employee) {
		String sql = "update tbl_employees set active=? where employee_id=?";
		Object[] params = { employee.getActive(), employee.getEmployeeId() };
		jdbcTemplate.update(sql, params);

	}

	public void delete(int id) {
		String sql = "delete from tbl_employees where employee_id=?";
		jdbcTemplate.update(sql, id);
	}
	
		public List<Employee> list() {
		String sql = "select employee_id,department_id,role_id,name,email_id,password,active  from tbl_employees";
		return jdbcTemplate.query(sql, (rs, rowNum) -> convert(rs));
	}

	private Employee convert(ResultSet rs) throws SQLException {

		Employee employee = new Employee();
		employee.setEmployeeId(rs.getInt("employee_id"));
		Department department = new Department();
		department.setDepartmentId(rs.getInt("department_id"));
		employee.setDepartmentId(department);

		Role role = new Role();
		role.setId(rs.getInt("role_id"));
		employee.setRoleId(role);

		employee.setName(rs.getString("name"));
		employee.setEmailId(rs.getString("email_id"));
		employee.setPassword(rs.getString("password"));
		employee.setActive(rs.getBoolean("active"));
		return employee;
	}

	/*public String checkEmployeePassword(Employee employee) {
		String sql = "SELECT password FROM tbl_employees WHERE email_id=?";
		Object[] params = { employee.getEmailId() };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			Employee employees = new Employee();
			employees.setPassword(rs.getString("password"));
			;
			return employees.getPassword();
		});

	}*/
	
	public Employee getPassword(String emailId) {
		String sql = "SELECT password FROM tbl_employees WHERE email_id=?";
		Object[] params = { emailId };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			Employee employee = new Employee();
			employee.setPassword(rs.getString("password"));
			return employee;
		});
	}
	

	public Employee findEmployeeId(String emailId) {
		String sql = "SELECT employee_id FROM tbl_employees WHERE email_id = ?";
		Object[] params = { emailId };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
			Employee employee = new Employee();
			employee.setEmployeeId(rs.getInt("employee_id"));
			return employee;

		});

	}

	public Employee findEmployeeDepartmentId(int id) {
		String sql = "SELECT department_id FROM tbl_employees WHERE employee_id = ?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
			Employee employee = new Employee();
			Department department = new Department();
			department.setDepartmentId(rs.getInt("department_id"));
			employee.setDepartmentId(department);
			return employee;

		});

	}

	public Employee findEmployeeRoleId(int id) {
		String sql = "SELECT role_id FROM tbl_employees WHERE employee_id = ?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
			Employee employee = new Employee();
			Role role = new Role();
			role.setId(rs.getInt("role_id"));
			employee.setRoleId(role);
			return employee;

		});

	}
}

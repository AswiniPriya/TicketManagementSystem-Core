package com.ticket.dao;

import java.util.Iterator;
import java.util.List;

import com.ticket.model.Employee;
//import com.ticket.model.Role;

public class TestEmployeeDao {

	public static void main(String[] args) {
		EmployeeDao employeeDao = new EmployeeDao();
		//Employee employee = new Employee();
//		employee.setEmployeeId(1);
//		Role role = new Role();
//		role.setId(1);
//		employee.setRoleId(role);

		// Department department = new Department();
		// department.setDepartmentId(1);
		//
		// employee.setDepartmentId(department);

		// employee.setName("Priya");
		// employee.setEmailId("aswinipriya184@gmail.com");
		 //employee.setActive(true);
		//employee.setPassword("abi");

		// employeeDao.save(employee);
		// employeeDao.updateDepartmentId(employee);
		//employeeDao.updateRole(employee);
		//employeeDao.updatePassword(employee);
//		employeeDao.updateActive(employee);
//		employeeDao.delete(1);
		List<Employee> list = employeeDao.list();
		Iterator<Employee> i = list.iterator();
		while (i.hasNext()) {
			Employee employee = (Employee) i.next();
			System.out.println(employee.getEmployeeId() + "\t" + employee.getDepartmentId().getDepartmentId() + "\t"
					+ employee.getRoleId().getId() + "\t" + employee.getName()+ "\t" + employee.getEmailId()+ 
					"\t" + employee.getPassword()+ "\t" + employee.getActive());
		}
	}
}

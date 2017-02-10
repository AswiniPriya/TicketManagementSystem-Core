package com.ticket.dao;

import java.util.List;

import com.ticket.model.Department;

public class TestDepartmentDao {
	public static void main(String[] args) {
	DepartmentDao departmentDao = new DepartmentDao();
	Department department = new Department();
	department.setDepartmentId(2);
	department.setName("Front End");
	//department.setActive(true);
	//departmentDao.save(department);
	//departmentDao.updateActive(department);
	//departmentDao.updateName(department);
	departmentDao.delete(2);
	List<Department> list = departmentDao.list();
	for (Department i : list) {
		System.out.println(i);
	}
	}
	
}

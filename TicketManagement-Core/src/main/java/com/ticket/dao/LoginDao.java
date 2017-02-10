package com.ticket.dao;


public class LoginDao {
	UserDao userDao = new UserDao();
	EmployeeDao employeeDao=new EmployeeDao();

	public boolean login(String emailId, String Password) {
		String result = userDao.getPassword(emailId).getPassword();
		if (result.equals(Password)){
			return true;}
		return false;
		}
	
	public boolean employeelogin(String emailId, String Password) {
		String result = employeeDao.getPassword(emailId).getPassword();
		if (result.equals(Password)){
			return true;}
		return false;
		}
	
	
//	public boolean EmployeeLogin(Employee employee)
//	{
//		String result=employeeDao.checkEmployeePassword(employee);
//		if(result.equals(employee.getPassword()))
//		{
//			return true;
//		}
//		return false;
//	}
}

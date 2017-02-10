package com.ticket.dao;
import com.ticket.dao.LoginDao;
public class TestLoginDao {
	public static void main(String[] args) {
		 LoginDao login = new LoginDao();
		 System.out.println(login.login("aswinisnsct@gmail.com", "aswiniabi"));
		}
}
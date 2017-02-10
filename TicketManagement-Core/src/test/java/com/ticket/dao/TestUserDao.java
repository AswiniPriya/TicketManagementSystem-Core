package com.ticket.dao;

import java.util.List;

import com.ticket.model.User;

public class TestUserDao {
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		User user = new User();
		user.setUserId(2);
//		user.setName("Priya");
//		user.setEmailId("aswinipriya184@gmail.com");
//		user.setMobileNumber(944200152);
//		user.setActive(false);
//		user.setPassword("abi1");
		//userDao.save(user);
		//userDao.updatePassword(user);
		//userDao.updateMobileNumber(user);
		//userDao.updateActive(user);
		//userDao.delete(2);
		List<User> list = userDao.list();
		for (User i : list) {
			System.out.println(i);
		}
	}
}

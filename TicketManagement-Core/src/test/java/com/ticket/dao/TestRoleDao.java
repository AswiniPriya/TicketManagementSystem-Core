package com.ticket.dao;

import java.util.Iterator;
import java.util.List;

import com.ticket.model.Role;

public class TestRoleDao {
public static void main(String[] args) {
		
		RoleDao roleDao=new RoleDao();
	
		
		Role role=new Role();
		//role.setName("Manager");
		role.setActive(false);
		role.setId(3);
		//roleDao.save(role);
		//roleDao.update(role);
	
	//roleDao.delete(3);
//		
		List<Role> list = roleDao.list();
		Iterator<Role> i = list.iterator();
		while (i.hasNext()) {
			Role roles=(Role) i.next();
			System.out.println(roles.getId()+"\t"+roles.getName()+"\t"+roles.getActive());
		}
}
}
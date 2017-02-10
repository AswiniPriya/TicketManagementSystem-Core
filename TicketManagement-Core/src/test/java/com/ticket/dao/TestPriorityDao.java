package com.ticket.dao;

import java.util.Iterator;
import java.util.List;

import com.ticket.model.Priority;

public class TestPriorityDao {
public static void main(String[] args) {
		
		PriorityDao priorityDao=new PriorityDao();
		
		//Priority priority=new Priority();
		
//		priority.setId(2);
//		priority.setActive(false);
		//priorityDao.save(priority);
		

	//priorityDao.update(priority);
//		
	priorityDao.delete(2);
//		
		List<Priority> list = priorityDao.list();
		Iterator<Priority> i = list.iterator();
		while (i.hasNext()) {
			Priority priority=(Priority) i.next();
			System.out.println(priority.getId()+"\t"+priority.getPriority()+"\t"+priority.getActive());
		}
		
	}
}

package com.hibernate.main;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hiberanate.model.Employee;
import com.hiberanate.model.Projects;
import com.hiberanate.session.SessionProvider;

public class App {
	public static void main(String[] args) {
		
		Session session = SessionProvider.getSession();
		System.out.println(session);

		Employee emp = new Employee();
		emp.setE_id(122);
		emp.setName("Pritam Ray");

		Projects projects1 = new Projects();
		projects1.setP_id(43);
		projects1.setP_name("Chatbots");
		projects1.setEmployee(emp);

		Projects projects2 = new Projects();
		projects2.setP_id(143);
		projects2.setP_name("Library Mamangement System");
		projects1.setEmployee(emp);

		List<Projects> list = new ArrayList<Projects>();
		list.add(projects1);
		list.add(projects2);
		emp.setList(list);
		
		Transaction transaction = session.beginTransaction();
		
		session.save(emp);
		session.save(projects1);
		session.save(projects2);
		
		transaction.commit();
	}
}

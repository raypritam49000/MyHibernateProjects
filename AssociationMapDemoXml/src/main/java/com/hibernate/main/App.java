package com.hibernate.main;

import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Employee;
import com.hibernate.session.SessionProvider;

public class App {
	public static void main(String[] args) {
		Session session = SessionProvider.getSession();
		System.out.println(session);

		Employee e = new Employee();
		e.setName("Junaid");

		HashMap<String, String> l = new HashMap<String, String>();
		l.put("12", "57");
		l.put("98", "33");
		e.setMob(l);

		Employee e1 = new Employee();
		e1.setName("abc");

		HashMap<String, String> l1 = new HashMap<String, String>();
		l1.put("90", "57");
		l1.put("99", "34");
		e1.setMob(l1);

		Transaction tx = session.beginTransaction();
		session.save(e);
		session.save(e1);
		tx.commit();

		Employee ee = (Employee) session.load(Employee.class, 1);

		System.out.println("Objects r Saved....");
	}
}

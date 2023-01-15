package com.core.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.core.hibernate.model.Student;

public class App {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		System.out.println(cfg);

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		System.out.println(sessionFactory);
		
		Session session = sessionFactory.openSession();
		System.out.println(session);
		
		Student st = new Student();
		st.setId(1710421);
		st.setName("Pritam Ray");
		st.setEmail("pray49000@gmail.com");
		st.setMobile(8699535682l);
		
		session.save(st);
		
		Transaction transaction = session.beginTransaction();
		System.out.println(transaction);
		transaction.commit();

	}
}

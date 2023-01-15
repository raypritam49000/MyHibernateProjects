package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.Student;

public class MainDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		System.out.println(cfg);

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		System.out.println(sessionFactory);

		Session session = sessionFactory.openSession();
		System.out.println(session);

		Student st = new Student();
		st.setId(123);
		st.setName("Raj Kumar");
		st.setAge(23);
		st.setMobile(8699535682l);

		session.save(st);

		Transaction transaction = session.beginTransaction();
		transaction.commit();
        
		session.close();
	}

}

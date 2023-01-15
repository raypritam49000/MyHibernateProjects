package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.Student;

public class AppTest {

	public static void main(String[] args)
	{
		Configuration cfg = new Configuration();
		cfg.configure();
		System.out.println(cfg);

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		System.out.println(sessionFactory);
		
		Session session = sessionFactory.openSession();
		System.out.println(session);
		
		Student st = new Student();
		st.setName("Pritam Ray");
		st.setMobile(8699535682l);
		
		Transaction transaction = session.beginTransaction();
		session.save(st);
		
		transaction.commit();
		Object ob = session.load(Student.class,new Integer(1));
		Student st1 = (Student) ob;
		
		System.out.println(st1.getName());
		System.out.println(st1.getMobile());
		
	}

}

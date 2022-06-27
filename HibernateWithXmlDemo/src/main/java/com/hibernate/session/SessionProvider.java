package com.hibernate.session;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.core.hibernate.model.Employee;

public class SessionProvider {
public static Session session;

	public static Session getSession() {
		if(session==null) {
			return new Configuration().configure("hibernate.cfg.xml").addResource("student.hbm.xml").addAnnotatedClass(Employee.class).buildSessionFactory().openSession();
		}
		return session;
	}
}

package com.hibernate.sessionconnection;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SessionProvider {

	private SessionProvider() {

	}

	public static Session session = null;

	public static Session getSession() {
		
		session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		

		return session;

	}
}

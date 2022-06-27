package com.hibernate.session;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public final class SessionProvider {
	
public static Session session = null;

	private SessionProvider() {
		
	}
	
	public static Session getSession() {
		if(session==null) {
			session = new Configuration().configure().buildSessionFactory().openSession();
			return session;
		}
		return session;
	}
	
}

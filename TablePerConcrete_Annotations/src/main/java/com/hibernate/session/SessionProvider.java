package com.hibernate.session;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SessionProvider {
  public static Session session;
  
  public static Session getSession() {
	  return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
  }
}

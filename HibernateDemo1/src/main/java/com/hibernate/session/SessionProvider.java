package com.hibernate.session;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.hibernate.model.Employee;

public class SessionProvider {
	public static Session session;
	
	public static Session getSession() {
		if(session==null) 
		{
			Properties properties = new Properties();
			properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
			properties.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
			properties.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/orm");
			properties.setProperty(Environment.USER, "root");
			properties.setProperty(Environment.PASS, "1998");
			properties.setProperty(Environment.HBM2DDL_AUTO,"create");
			properties.setProperty(Environment.SHOW_SQL, "true");
			properties.setProperty(Environment.FORMAT_SQL, "true");
			
			
			Configuration cfg = new Configuration();
			cfg.setProperties(properties);
			cfg.addAnnotatedClass(Employee.class);
			
			SessionFactory factory = cfg.buildSessionFactory();
			session = factory.openSession();
			
			return session;
			
		}
		
		return session;
		
	}

}

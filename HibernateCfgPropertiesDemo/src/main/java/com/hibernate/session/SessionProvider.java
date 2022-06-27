package com.hibernate.session;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.hibernate.model.Student;



public class SessionProvider {
	
	public static Session session = null;
	
	public static Session getSession() {
		Properties properties = new Properties();

        properties.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/orm");
        properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        properties.setProperty(Environment.USER, "root");
        properties.setProperty(Environment.PASS, "1998");
        properties.setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        properties.setProperty(Environment.SHOW_SQL, "true"); 
        properties.setProperty(Environment.FORMAT_SQL, "true"); 
        properties.setProperty(Environment.HBM2DDL_AUTO,"create");
        
        Configuration configuration = new Configuration();
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(Student.class);
        
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        
        session = sessionFactory.openSession();
        
        return session;
        
     }
     

}

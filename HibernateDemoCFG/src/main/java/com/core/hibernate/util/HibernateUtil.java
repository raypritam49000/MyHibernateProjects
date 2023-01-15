package com.core.hibernate.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.core.hibernate.beans.Student;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getsessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				// hibernate settings equivalent to hibernate.cfg.xml's properties

				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/orm");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "1998");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.FORMAT_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "create-drop");

				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Student.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			}
			catch (Exception e) 
			{
               e.printStackTrace();
			}
		}
		return sessionFactory;
	}

}

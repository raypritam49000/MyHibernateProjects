package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();

		cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/orm");
		cfg.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		cfg.setProperty("dialect", "org.hibernate.dialect.MySQL8Dialect");
		cfg.setProperty("hibernate.connection.username", "root");
		cfg.setProperty("hibernate.connection.password", "1998");
		cfg.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		cfg.setProperty("hibernate.show_sql", "true");
		cfg.setProperty("hibernate.format_sql", "true");
		
		cfg.addAnnotatedClass(Customer.class);
		System.out.println(cfg);

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		System.out.println(sessionFactory);

		Session session = sessionFactory.openSession();
		System.out.println(session);

		Customer user = new Customer();
		user.setId(123);
		user.setName("Raj Kumar");

		Transaction transaction = session.beginTransaction();

		session.save(user);

		transaction.commit();
		System.out.println("Data Saved Sucessfully...");
	}
}

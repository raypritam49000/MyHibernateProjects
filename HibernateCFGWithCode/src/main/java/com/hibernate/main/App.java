package com.hibernate.main;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.hibernate.model.Address;
import com.hibernate.model.Customer;

public class App {
	public static void main(String[] args) {

		Properties properties = new Properties();
		properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
		properties.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
		properties.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/orm");
		properties.setProperty(Environment.USER, "root");
		properties.setProperty(Environment.PASS, "1998");
		properties.setProperty(Environment.HBM2DDL_AUTO, "create");
		properties.setProperty(Environment.SHOW_SQL, "true");
		properties.setProperty(Environment.FORMAT_SQL, "true");

		Configuration cfg = new Configuration();
		cfg.setProperties(properties);
		cfg.addAnnotatedClass(Customer.class);
		cfg.addAnnotatedClass(Address.class);
		System.out.println(cfg);

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		System.out.println(sessionFactory);

		Session session = sessionFactory.openSession();
		System.out.println(session);

		Customer customer = new Customer();
		customer.setC_id(234);
		customer.setC_name("Omi Verma");

		Address address = new Address();
		address.setAdd_id(543);
		address.setAdd_name("Ropar");

		customer.setAdd(address);
		address.setCustomer(customer);

		Transaction transaction = session.beginTransaction();

		session.save(customer);
		session.save(address);

		transaction.commit();
	}
}

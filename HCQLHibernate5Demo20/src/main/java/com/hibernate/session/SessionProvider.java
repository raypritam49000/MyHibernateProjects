package com.hibernate.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.hibernate.beans.Department;
import com.hibernate.beans.Employee;

public class SessionProvider {
	public static Session getSession() {
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
		standardServiceRegistryBuilder.configure("hibernate.cfg.xml");
		StandardServiceRegistry standardServiceRegistry = standardServiceRegistryBuilder.build();

		MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
		metadataSources.addAnnotatedClass(Department.class).addAnnotatedClass(Employee.class);
		Metadata metadata = metadataSources.buildMetadata();
		SessionFactory sessionFactory = metadata.buildSessionFactory();
		Session session = sessionFactory.openSession();
		return session;

	}
}

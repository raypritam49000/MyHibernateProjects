package com.hibernate.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		System.out.println("Projects Starting...");
		Configuration cfg = new Configuration();
		System.out.println(cfg);
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		System.out.println(sessionFactory);

		// create the Employee
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();

		emp1.setE_id(34);
		emp1.setE_name("Pritam Ray");

		emp2.setE_id(36);
		emp2.setE_name("Omi Verma");

		// create the Project
		Project pro1 = new Project();
		Project pro2 = new Project();

		pro1.setP_id(323);
		pro1.setP_name("Library Managment System");

		pro2.setP_id(422);
		pro2.setP_name("ChatBots");

		List<Employee> employee = new ArrayList<Employee>();
		List<Project> project = new ArrayList<Project>();

		employee.add(emp1);
		employee.add(emp2);

		project.add(pro1);
		project.add(pro2);

		emp1.setProject(project);
		pro2.setEmployee(employee);

		Session session = sessionFactory.openSession();
		System.out.println(session);

		session.save(emp1);
		session.save(emp2);
		
		session.save(pro1);
		session.save(pro2);

		Transaction transaction = session.beginTransaction();
        transaction.commit();
        
		System.out.println("Project Finishs...");

	}
}

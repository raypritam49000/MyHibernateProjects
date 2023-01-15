package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Employee;
import com.hibernate.model.Student;
import com.hibernate.session.SessionProvider;

public class App {
	public static void main(String[] args) {
		System.out.println("Starting the Project.....");
		Session session = SessionProvider.getSession();
		System.out.println(session);

		Employee e = new Employee();
		e.setName("Rohit Kumar");
		e.setAge(34);
		e.setSalary(5300);

		Student st = new Student();
		st.setAge(19);
		st.setName("Raj Kumar");
		st.setRollno(431);

		Transaction transaction = session.beginTransaction();
		session.save(e);
		session.save(st);

		transaction.commit();

		System.out.println("Table Per class  Hierarchy Successfully...");
	}
}

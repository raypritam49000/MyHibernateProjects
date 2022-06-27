package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Employee;
import com.hibernate.model.Person;
import com.hibernate.model.Student;
import com.hibernate.session.SessionProvider;

public class Test {

	public static void main(String[] args) {
		System.out.println("Starting Project....");
        Session session = SessionProvider.getSession();
        System.out.println(session);

		Employee e = new Employee();
		e.setName("Chandan Kumar");
		e.setAge(20);
		e.setSalary(1000);

		Student st = new Student();
		st.setAge(19);
		st.setName("Pritam Ray");
		st.setRollno(1710421);

		Transaction tx = session.beginTransaction();
		
		session.save(e);
		session.save(st);

		tx.commit();
		session.close();
		System.out.println("Table Per Concete Class Sucessfully....");

	}

}
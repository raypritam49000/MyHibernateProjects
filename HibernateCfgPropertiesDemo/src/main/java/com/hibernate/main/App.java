package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Student;
import com.hibernate.session.SessionProvider;

public class App {
	public static void main(String[] args) {
		Session session = SessionProvider.getSession();
		System.out.println(session);

		Transaction transaction = session.beginTransaction();

        Student student = new Student();
        student.setName("Pritam Ray");
        student.setMobile(8699535682l);
        student.setCity("Ropar");
        
        session.save(student);

     	transaction.commit();


	}
}

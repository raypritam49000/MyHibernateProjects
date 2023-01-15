package com.hibernate.dto;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Student;
import com.hibernate.sessionconnection.SessionProvider;

public class StudentDto {

	public static void studentRegister(Student student) {
		Session session = SessionProvider.getSession();
		Integer i = (Integer) session.save(student);
		//System.out.println("Serializiable Id = "+i);
		//session.persist(student);
		//session.saveOrUpdate(student);
		//session.createQuery("");
		Transaction transaction = session.beginTransaction();
		transaction.commit();
	}
}

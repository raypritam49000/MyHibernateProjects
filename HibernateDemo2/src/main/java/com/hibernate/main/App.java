package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.Student;

public class App {
	public static void main(String[] args) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		
		Student st = new Student("Pritam Ray","8699535682");
		
		session.save(st);
		
		Transaction transaction = session.beginTransaction();
		transaction.commit();
		
		
		
	}
}

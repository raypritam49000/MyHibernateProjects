package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Student;
import com.hibernate.session.HibernateUtil;

public class MainDemo {

	public static void main(String[] args) {
		Student st = new Student("Ram", "Kumar", "pray1900@gamil.com");

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transactions
			transaction = session.beginTransaction();

			// save the studnet objcet
			session.save(st);

			transaction.commit();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}

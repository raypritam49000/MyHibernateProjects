package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		System.out.println(cfg);
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		System.out.println(sessionFactory);

		// create question
		Question qus1 = new Question();
		qus1.setQuestion_id(123);
		qus1.setQuestion("What is Java ?");

		// create answers
		Answers ans1 = new Answers();
		ans1.setAnswers_id(234);
		ans1.setAnswers("Java is Programming Language");
		
		qus1.setAnswer(ans1);
		ans1.setQuestion(qus1);

//		// create question
//		Question qus2 = new Question();
//		qus2.setQuestion_id(523);
//		qus2.setQuestion("What is your name ?");
//
//		// create answers
//		Answers ans2 = new Answers();
//		ans2.setAnswers_id(534);
//		ans2.setAnswers("My Name is Pritam Ray");
//		qus2.setAnswer(ans2);
//
//		// create question
//		Question qus3 = new Question();
//		qus3.setQuestion_id(6533);
//		qus3.setQuestion("What is your father name ?");
//
//		// create answers
//		Answers ans3 = new Answers();
//		ans3.setAnswers_id(1534);
//		ans3.setAnswers("My father Name is Apurba Kumar Ray");
//		qus3.setAnswer(ans3);

		// open session
		Session session = sessionFactory.openSession();
		System.out.println(session);
		Transaction transaction = session.beginTransaction();

		// save
		session.save(qus1);
		session.save(ans1);
		
//		session.save(qus2);
//		session.save(ans2);
//		
//		session.save(qus3);
//		session.save(ans3);

		transaction.commit();
		session.close();

	}
}

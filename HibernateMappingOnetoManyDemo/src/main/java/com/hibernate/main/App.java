package com.hibernate.main;

import java.util.ArrayList;
import java.util.List;

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
		qus1.setQuestion_id(24);
		qus1.setQuestion("What is Java ?");

		// create answers
		Answers ans1 = new Answers();
		ans1.setAnswers_id(134);
		ans1.setAnswers("Java is Programming Language");
		ans1.setQuestion(qus1);
		
		Answers ans2 = new Answers();
		ans2.setAnswers_id(154);
		ans2.setAnswers("Java Program can be used to developed by software");
		ans2.setQuestion(qus1);
		
		Answers ans3 = new Answers();
		ans3.setAnswers_id(144);
		ans3.setAnswers("Java can be support opps concept");
		ans3.setQuestion(qus1);
		
		List<Answers> list = new ArrayList<Answers>();
		list.add(ans1);
		list.add(ans2);
		list.add(ans3);
		
		qus1.setAnswers(list);
		
		// open session
		Session session = sessionFactory.openSession();
		System.out.println(session);
		Transaction transaction = session.beginTransaction();

		// save
		session.save(qus1);
		session.save(ans1);
		session.save(ans2);
		session.save(ans3);
        
		transaction.commit();
		
		Object obj = session.get(Question.class,24);
		Question question = (Question) obj;
		
		System.out.println(question.getQuestion());
		
		for(Answers a : question.getAnswers()) {
			System.out.println(a.getAnswers());
		}
		session.close();

	}
}

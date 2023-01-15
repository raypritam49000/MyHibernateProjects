package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.model.Student;
import com.hibernate.session.HibernateUtil;

public class MainDemo {

	public static void main(String[] args) 
	{
	  System.out.println("Starting the Projects....");
	  SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	  System.out.println(sessionFactory);
	  
	  Session session =  sessionFactory.openSession();
	  System.out.println(session);
	  
	  Student st = new Student();
	  st.setId(4343);
	  st.setName("Pritam Ray");
	  st.setAge(23);
	  st.setMobile(8699535682l);
      
	  Transaction transaction = session.beginTransaction();
	  System.out.println(transaction);
	  
	  session.save(st);
	  
	  transaction.commit();
	  System.out.println("Projects Finishs.....");
	}

}

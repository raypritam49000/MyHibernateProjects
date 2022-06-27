package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.hibernate.model.Employee;
import com.hibernate.model.Student;
import com.hibernate.session.SessionProvider;

public class Test {

	public static void main(String[] args) {
		
        Session session = SessionProvider.getSession();
        System.out.println(session);
		
		Employee e = new Employee();
		e.setName("Pritam Ray");
		e.setAge(25);
		e.setSalary(30000);

		Student st = new Student();
		st.setAge(24);
		st.setName("Omi Verma");
		st.setRollno(1710421);

		Transaction tx = session.beginTransaction();
		
		session.save(e);
		session.save(st);

		tx.commit();
		session.close();
		
		System.out.println("Objects r Saved....");

	}

}
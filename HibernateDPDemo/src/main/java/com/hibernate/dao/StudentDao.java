package com.hibernate.dao;

import org.hibernate.Session;

import com.hibernate.model.Student;
import com.hibernate.sessionconnection.SessionProvider;

public class StudentDao {
 
	public static void getStudent(Student student) {
		Session session = SessionProvider.getSession();
		//Object obj = session.load(Student.class,new Integer(65544));
		Object obj = session.get(Student.class,new Integer(student.getId()));
		Student st = (Student) obj;
		System.out.println(st);
		System.out.println(st.getId());
		System.out.println(st.getName());
		System.out.println(st.getAge());
		System.out.println(st.getAddrsss());
		
		
		
	}
}

package com.hibernate.main;

import com.hibernate.model.Student;
import com.hibernate.session.SessionProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);
        
        Student student = new Student();
        student.setStudentId(103);
        student.setStudentAddress("Hyderabad");
        student.setStudentName("Johny");
        student.setCourceId(201);
        
        Transaction tx = session.beginTransaction();
        session.save(student);
        tx.commit();
        session.close();
        System.out.println("Projects are run sucessfully....");
    }

}

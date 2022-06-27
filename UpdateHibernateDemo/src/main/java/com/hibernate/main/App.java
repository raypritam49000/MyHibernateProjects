package com.hibernate.main;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        System.out.println("Starting the Projects.....");
        Configuration cfg = new Configuration();
        cfg.configure();
        System.out.println(cfg);
        
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        System.out.println(sessionFactory);
        
        Session session = sessionFactory.openSession();
        System.out.println(session);
        
        Student st = new Student();
        st.setName("Pritam Ray");
        st.setAge(25);
        st.setAddress("Prem Nagar");
        
        Transaction transaction = session.beginTransaction();
        session.save(st);
        transaction.commit();
        
        Object object = session.get(Student.class,st.getId());
        Student student = (Student) object;
        System.out.println("Student Id :- "+student.getId());
        System.out.println("Student Name :- "+student.getName());
        System.out.println("Student Address :- "+student.getAddress());
        System.out.println("Student Age:- "+student.getAge());
       
        Transaction trx = session.beginTransaction();
        
        student.setName("Raj Kumar");
        student.setAge(34);
        student.setAddress("Ropar");
        
        session.update(student);
        
        trx.commit();
        
        
        Object object1 = session.get(Student.class,student.getId());
        Student student1 = (Student) object1;
        System.out.println("Student Id :- "+student1.getId());
        System.out.println("Student Name :- "+student1.getName());
        System.out.println("Student Address :- "+student1.getAddress());
        System.out.println("Student Age:- "+student1.getAge());
        
        session.beginTransaction();
        session.delete(student);
        session.getTransaction().commit();
    }
 
}

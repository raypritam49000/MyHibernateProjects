package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Employee;
import com.hibernate.session.SessionProvider;

public class App 
{
    public static void main( String[] args )
    {
        Session session = SessionProvider.getSession();
        System.out.println(session);
        
        Transaction tx = session.beginTransaction();
        Employee employee = new Employee("Ajit", "test@gmail.com");
        session.persist(employee);
        System.out.println("Employee saved");
        tx.commit();
        session.close();
    }
}

package com.hibernate.main;

import com.hibernate.model.Employee;
import com.hibernate.session.SessionProvider;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;

public class AppMain {
    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);
        
        Employee employee = new Employee();
        employee.setEname("Pritam Ray");
        
        Set mobile1 = new HashSet();
        mobile1.add("8699535682");
        mobile1.add("7696708539");
        
        Set mobile2 = new HashSet();
        mobile2.add("8664865682");
        mobile2.add("7645422539");
        
        employee.setMobile(mobile1);
        employee.setMobile(mobile2);
        
        session.beginTransaction();
        session.persist(employee);
        session.getTransaction().commit();
    }
  
}

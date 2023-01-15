package com.hibernate.main;

import com.hibernate.model.Employee;
import com.hibernate.session.SessionProvider;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.Session;

public class AppMain {
    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);
        
        Map<String,String> mobiles1 = new HashMap<>();
        mobiles1.put("mobile1","8699535682");
        mobiles1.put("mobile2","8693423682");
        
        Map<String,String> mobiles2 = new HashMap<>();
        mobiles2.put("mobile1","9041414564");
        mobiles2.put("mobile2","9453124333");
        
        Employee employee1 = new Employee("Pritam Ray",mobiles1);
        Employee employee2 = new Employee("Omi Verma",mobiles2);
        
        session.beginTransaction();
        
        session.persist(employee1);
        session.persist(employee2);
        
        session.getTransaction().commit();
    }
   
}

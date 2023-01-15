package com.hibernate.main;

import com.hibernate.model.Address;
import com.hibernate.model.Employee;
import com.hibernate.session.SessionProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppMain {
    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);
        
        Employee employee = new Employee();
        employee.setEmpId(786);
        employee.setName("Pritam Ray");
        employee.setSalary(30000.00f);
        
        Address address = new Address();
        address.setAddId(420);
        address.setCity("Ropar");
        address.setState("Punjab");
        address.setCountry("India");
        
        address.setEmployee(employee);
        
        Transaction transaction = session.beginTransaction();
        
        session.save(employee);
        session.save(address);
        
        transaction.commit();
    }
}

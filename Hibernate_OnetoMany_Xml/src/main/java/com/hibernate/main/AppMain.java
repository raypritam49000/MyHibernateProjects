package com.hibernate.main;

import com.hibernate.model.Address;
import com.hibernate.model.Employee;
import com.hibernate.session.SessionProvider;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppMain {
    public static void main(String[] args) {
        System.out.println("Starting the Projects.....");
        Session session = SessionProvider.getSession();
        System.out.println(session);
        
        Employee employee = new Employee();
        employee.setName("Pritam Ray");
        employee.setSalary(30000.00f);
        
        Address address = new Address();
        address.setCity("Ropar");
        address.setState("Punjab");
        address.setCountry("India");
        
        Address address1 = new Address();
        address1.setCity("Nawasaher");
        address1.setState("Punjab");
        address1.setCountry("India");
        
        Address address2 = new Address();
        address2.setCity("Prem Nagar");
        address2.setState("Chandigrah");
        address2.setCountry("India");
        
        Set<Address> addressess = new HashSet<>();
        addressess.add(address);
        addressess.add(address1);
        addressess.add(address2);
        
        employee.setAddress(addressess);
        address.setEmployee(employee);
        address1.setEmployee(employee);
        address2.setEmployee(employee);
        
        Transaction transaction = session.beginTransaction();
        
        session.save(employee);
        
        transaction.commit();
        System.out.println("Projects to be sucessfully......");
    }
}

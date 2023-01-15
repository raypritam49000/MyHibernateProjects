package com.hibernate.main;

import com.hibernate.model.Employee;
import com.hibernate.session.SessionProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {
        System.out.println("Starting the Project.....");
        Session session = SessionProvider.getSession();
        System.out.println(session);
        
        Employee employee = new Employee();
        employee.setName("Omi Verma");
        employee.setAge(26);
        
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        
        Employee employee1 = (Employee)session.byId(Employee.class).getReference(employee.getId());
        System.out.println("Employee Name : "+employee1.getName());
        System.out.println("Employee Age : "+employee1.getAge());
        System.out.println("Employee ID : "+employee1.getId());
        
        System.out.println("Project are Run Sucessfully....");
    }
  
}

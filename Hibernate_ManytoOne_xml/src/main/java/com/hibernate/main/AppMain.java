package com.hibernate.main;

import com.hibernate.model.Department;
import com.hibernate.model.Employee;
import com.hibernate.session.SessionProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppMain {
    public static void main(String[] args) {
        System.out.println("Starting the Projects.....");
        Session session = SessionProvider.getSession();
        System.out.println(session);
        
        Department department = new Department();
        department.setDeptName("Computer Science");
        
        Employee employee1 = new Employee();
        employee1.setEmpName("Pritam Ray");
        employee1.setEmpAddress("Prem Nagar");
        employee1.setDepartment(department);
        
        Employee employee2 = new Employee();
        employee2.setEmpName("Omi Verma");
        employee2.setEmpAddress("Ropar");
        employee2.setDepartment(department);
        
        Employee employee3 = new Employee();
        employee3.setEmpName("Chandan Kumar");
        employee3.setEmpAddress("UK");
        employee3.setDepartment(department);
        
        session.beginTransaction();
        
        session.save(employee1);
        session.save(employee2);
        session.save(employee3);
        
        session.getTransaction().commit();
        
        
       
        
        Transaction transaction = session.beginTransaction();
        
        
        
        transaction.commit();
        System.out.println("Projects to be sucessfully......");
    }
}

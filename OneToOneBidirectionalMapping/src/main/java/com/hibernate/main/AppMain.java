package com.hibernate.main;

import com.hibernate.model.Employee;
import com.hibernate.model.Employee_Address;
import com.hibernate.session.SessionPovider;
import org.hibernate.Session;

public class AppMain {
    public static void main(String[] args) {
        Session session = SessionPovider.getSession();
        System.out.println(session);
        
         //Create Employee object
        Employee employee = new Employee();
        
        //Set value to Employee class properties
        employee.setId(6434);
        employee.setAge(102);
        employee.setDept("IT");
        employee.setName("JIP");
        
        //Create new Employee Address Object
        Employee_Address employeeAddress = new Employee_Address();
        
        //Set values to Employee_Address class properties
        employeeAddress.setStreet("Test Street");
        employeeAddress.setCity("Test City");
        employeeAddress.setState("Test State");
        employeeAddress.setCountry("Test Countty");
        
        //Bi directional association
        employee.setEmployeeAddress(employeeAddress);
        employeeAddress.setEmployee(employee);
        
        
        session.beginTransaction();
        
        session.save(employee);
        session.save(employeeAddress);
        
        session.getTransaction().commit();
    }
 
}

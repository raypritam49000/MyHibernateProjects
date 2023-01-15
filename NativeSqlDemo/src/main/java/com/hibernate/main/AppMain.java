package com.hibernate.main;

import com.hibernate.model.Employee;
import static com.hibernate.session.SessionProvider.getSession;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class AppMain {

    public static void main(String[] args) {
        Session session = getSession();
        System.out.println(session);

        Employee employee1 = new Employee("Pritam", "Ray", 15000);
        Employee employee2 = new Employee("Raj", "Kumar", 25000);
        Employee employee3 = new Employee("Rahul", "Kumar", 35000);
        Employee employee4 = new Employee("Ram", "Kumar", 45000);
        
        session.beginTransaction();
        
        session.persist(employee1);
        session.persist(employee2);
        session.persist(employee3);
        session.persist(employee4);
        
        session.getTransaction().commit();

        String sql = "SELECT * FROM EMPLOYEE WHERE id = :employee_id";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Employee.class);
        query.setParameter("employee_id", 3);
        List<Employee> results = query.list();
        
        for(Employee emp : results){
            System.out.println(emp.getId()+" "+emp.getFirstName()+" "+emp.getLastName()+" "+emp.getSalary());
        }
        
        
        
      
    }

}

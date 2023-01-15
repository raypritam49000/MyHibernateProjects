package com.hibernate.main;

import com.hibernate.model.Employee;
import com.hibernate.session.SessionProvider;
import java.util.Iterator;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;

public class App {

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);
        
        session.beginTransaction();
        
        Employee employee1 = new Employee("Pritam Ray",45000,"Java Developer");
        Employee employee2 = new Employee("Omi Verma",15000,"PHP Developer");
        Employee employee3 = new Employee("Raj Kumar",39880,"Cpp Developer");
        Employee employee4 = new Employee("Raj Kumar",35000,"Android Developer");
        
        session.persist(employee1);
        session.persist(employee2);
        session.persist(employee3);
        session.persist(employee4);
        
        session.getTransaction().commit();

        TypedQuery query = session.getNamedQuery("findEmployeeByName");
        query.setParameter("name", "Pritam Ray");

        List<Employee> employees = query.getResultList();

        Iterator<Employee> itr = employees.iterator();
        while (itr.hasNext()) {
            Employee e = itr.next();
            System.out.println(e);
        }
        session.close();

    }

}

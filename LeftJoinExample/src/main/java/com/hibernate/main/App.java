package com.hibernate.main;

import com.hibernate.model.Address;
import com.hibernate.model.Employee;
import static com.hibernate.session.SessionProvider.getSession;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class App {

    public static void main(String[] args) {
        Session session = getSession();
        System.out.println(session);

        Employee employee = new Employee("Pritam Ray", 24, 8699535682l);
        Address address = new Address("Ropar", "Punjab", "India");

        employee.setAddress(address);
        address.setEmployee(employee);

        session.beginTransaction();

        session.persist(employee);
        session.persist(address);

        session.getTransaction().commit();

        Query query = session.createQuery("from Employee as emp LEFT JOIN FETCH emp.address",Employee.class);
        List<Employee> list = query.getResultList();

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}

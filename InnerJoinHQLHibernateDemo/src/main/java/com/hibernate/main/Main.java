package com.hibernate.main;

import com.hibernate.model.Address;
import com.hibernate.model.Employee;
import static com.hibernate.session.SessionProvider.getSession;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {
        Session session = getSession();
        session.beginTransaction();
        
        Address address = new Address();
        address.setStreet("Prem Nagar");
        address.setCity("Ropar");
        address.setState("Punjab");
        address.setCountry("India");
        
        Employee employee1 = new Employee();
        employee1.setFirstname("Pritam");
        employee1.setLastname("Ray");
        employee1.setCellphone("8699545673");
        
        Employee employee2 = new Employee();
        employee2.setFirstname("Omi");
        employee2.setLastname("Verma");
        employee2.setCellphone("9087545673");
        
        Employee employee3 = new Employee();
        employee3.setFirstname("Chandan");
        employee3.setLastname("Verma");
        employee3.setCellphone("7900045673");
        
       List<Employee> employees = Arrays.asList(employee1,employee2,employee3);

        
        address.setEmployees(employees);
        employee1.setAddress(address);
        employee2.setAddress(address);
        employee3.setAddress(address);
        
        session.save(address);
        session.save(employee1);
        session.save(employee2);
        session.save(employee3);
       
        session.getTransaction().commit();
        
        System.out.println("********Hibernate Right Outer Join Example********");
        String hql = "select e.firstname,e.lastname,e.cellphone,a.city,a.state,a.country from Employee e right join e.address as a";
        Query query = session.createQuery(hql);

        System.out.println("First Name\t" + "Last Name\t" + "Cell Phone\t"
                + "City\t\t" + "State\t" + "Country\t");
        System.out.println("--------------------------------------------------------------------------------");

        Iterator it = query.iterate();
        while (it.hasNext()) {
            Object[] row = (Object[]) it.next();
            System.out.print(row[0] + " " + row[1] + " " + row[2] + " " + row[3] + " " + row[4] + " " + row[5]);
            System.out.println();

        }

    }
}

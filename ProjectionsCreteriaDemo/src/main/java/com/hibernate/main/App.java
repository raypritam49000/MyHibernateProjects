package com.hibernate.main;

import com.hibernate.model.Employee;
import com.hibernate.session.SessionProvider;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

public class App {

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);

        Employee employee1 = new Employee("Pritam Ray", "Ropar", 45000, 8699535682l);
        Employee employee2 = new Employee("Omi Verma", "Prem Nagar", 35000, 7696889454l);
        Employee employee3 = new Employee("JP Verma", "Asron", 56000, 8976453209l);
        Employee employee4 = new Employee("Chandan Kumar", "UK", 67000, 7009842345l);
        Employee employee5 = new Employee("Suraj Mehta", "RB Colony", 34000, 9867543564l);
        Employee employee6 = new Employee("Pritam Ray", "Ropar", 45000, 8699535682l);
        Employee employee7 = new Employee("Omi Verma", "Prem Nagar", 35000, 7696889454l);

        session.beginTransaction();

        session.save(employee1);
        session.save(employee2);
        session.save(employee3);
        session.save(employee4);
        session.save(employee5);
        session.save(employee6);
        session.save(employee7);

        session.getTransaction().commit();

        Criteria criteria = session.createCriteria(Employee.class);

//        criteria.setProjection(Projections.rowCount());
//        criteria.setProjection(Projections.avg("salary"));
//         criteria.setProjection(Projections.id());
//         criteria.setProjection(Projections.max("salary"));
//         criteria.setProjection(Projections.min("salary"));
//         criteria.setProjection(Projections.sum("salary"));
//         criteria.setProjection(Projections.countDistinct("name"));
        criteria.setProjection(Projections.property("name"));

        List<Employee> employess = criteria.list();

        System.out.println(employess.get(0));

    }
}

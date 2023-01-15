package com.hibernate.main;

import com.hibernate.model.Employee;
import com.hibernate.session.SessionProvider;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);

        Employee employee1 = new Employee("Pritam Ray", 23, 8699535683l, 45000.00);
        Employee employee2 = new Employee("Omi Verma", 25, 7658835683l, 23000.00);
        Employee employee3 = new Employee("Chandan Kumar", 26, 7000985383l, 54000.00);
        Employee employee4 = new Employee("Vikas Kumar", 29, 8699535683l, 15000.00);
        Employee employee5 = new Employee("Suraj Mehta", 33, 8699535683l, 65000.00);
        Employee employee6 = new Employee("Pritam Ray", 23, 8699535683l, 45000.00);

        session.beginTransaction();

        session.persist(employee1);
        session.persist(employee2);
        session.persist(employee3);
        session.persist(employee4);
        session.persist(employee5);
        session.persist(employee6);

        session.getTransaction().commit();

        Query query = session.createQuery("from Employee");
        List<Employee> list = query.getResultList();

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Employee employee = (Employee) iterator.next();
            System.out.println("Id : " + employee.getId());
            System.out.println("Name : " + employee.getName());
            System.out.println("Age : " + employee.getAge());
            System.out.println("Mobile : " + employee.getMobile());
            System.out.println("Salary :" + employee.getSalary());
        }

        Query q1 = session.createQuery("select sum(salary) from Employee");
        List<Integer> list1 = q1.getResultList();
        System.out.println(list1.get(0));

        Query q2 = session.createQuery("select max(salary) from Employee");
        List<Integer> list2 = q2.getResultList();
        System.out.println(list2.get(0));

        Query q3 = session.createQuery("select min(salary) from Employee");
        List<Integer> list3 = q3.getResultList();
        System.out.println(list3.get(0));

        Query q4 = session.createQuery("select count(id) from Employee");
        List<Integer> list4 = q4.getResultList();
        System.out.println(list4.get(0));

        Query q5 = session.createQuery("select avg(salary) from Employee");
        List<Integer> list5 = q5.getResultList();
        System.out.println(list5.get(0));

        Query q6 = session.createQuery("select distinct(name) from Employee");
        List<Integer> list6 = q6.getResultList();

        for (int i = 0; i <= list6.size() - 1; i++) {
            System.out.println(list6.get(i));
        }

        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("update Employee set name=:n where id=:i");
        q.setParameter("n", "Udit Kumar");
        q.setParameter("i", 6);

        int status = q.executeUpdate();
        System.out.println(status);
        tx.commit();

        Query q7 = session.createQuery("from Employee");
        List<Employee> list7 = q7.getResultList();

        for (int i = 0; i <= list7.size() - 1; i++) {
            Employee emp = (Employee) list7.get(i);
            System.out.println("Id : " + emp.getId());
            System.out.println("Name : " + emp.getName());
            System.out.println("Age : " + emp.getAge());
            System.out.println("Mobile : " + emp.getMobile());
            System.out.println("Salary :" + emp.getSalary());
        }

    }
}

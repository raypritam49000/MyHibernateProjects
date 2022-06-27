package com.hibernate.main;

import com.hibernate.model.Student;
import com.hibernate.session.SessionProvider;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppMain {

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);

        session.beginTransaction();

        Student student1 = new Student("Pritam Ray", "RGI", 23, "Ropar", 45000);
        Student student2 = new Student("Amit Kumar", "CGC", 26, "UK", 23540);
        Student student3 = new Student("Rajiv Kumr", "LU", 33, "Prem Nagar", 53111);
        Student student4 = new Student("Raj Kumar", "PTU", 63, "Asron", 43111);
        Student student5 = new Student("Ray Shahib", "RTC", 24, "Rail", 34522);

        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);
        session.save(student5);

        session.getTransaction().commit();

        Query query = session.createQuery("From Student");
        List list = query.getResultList();

        for (int i = 0; i <= list.size() - 1; i++) {
            System.out.println(list.get(i));
        }

        Transaction tx = session.beginTransaction();

        Query q = session.createQuery("update Student set name=:n where id=:i");
        q.setParameter("n", "Udit Kumar");
        q.setParameter("i", 1);

        int status = q.executeUpdate();
        System.out.println(status);

        Query query1 = session.createQuery("delete from Student where id=:i");
        query1.setParameter("i", 5);
        query1.executeUpdate();

        tx.commit();

        Query query2 = session.createQuery("From Student");
        List student = query2.getResultList();

        for (int i = 0; i <= student.size() - 1; i++) {
            System.out.println(student.get(i));
        }

        Query query3 = session.createQuery("select sum(fees) from Student");
        List list2 = query3.getResultList();
        System.out.println("Sum of All Fees : "+list2.get(0));
        
        Query query4 = session.createQuery("select max(fees) from Student");
        List list3 = query4.getResultList();
        System.out.println("Max Fess : "+list3.get(0));
        
        Query query5 = session.createQuery("select min(fees) from Student");
        List list4 = query5.getResultList();
        System.out.println("Min Fess : "+list4.get(0));
        
        Query query6 = session.createQuery("select count(fees) from Student");
        List list6 = query6.getResultList();
        System.out.println("Count Fess Pay Student : "+list6.get(0));
        
        Query query7 = session.createQuery("select avg(fees) from Student");
        List list7 = query7.getResultList();
        System.out.println("Average Fees : "+list7.get(0));
    }
}

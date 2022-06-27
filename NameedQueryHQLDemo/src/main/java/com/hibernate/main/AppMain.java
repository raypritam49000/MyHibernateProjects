package com.hibernate.main;

import com.hibernate.model.Customer;
import com.hibernate.session.SessionProvider;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class AppMain {

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();

        Customer customer1 = new Customer("Pritam Ray", "Ropar");
        Customer customer2 = new Customer("Chandan", "Uk");
        Customer customer3 = new Customer("Omi Verma", "RB Colony");
        Customer customer4 = new Customer("Amit Kumar", "Rail");
        Customer customer5 = new Customer("Suraj Kumar", "Rajpura");
        Customer customer6 = new Customer("Raj Kumar", "Power Colony");
        Customer customer7 = new Customer("Ram Kumar", "Mohali");
        Customer customer8 = new Customer("Ajit Kumar", "Asron");
        Customer customer9 = new Customer("Rahul Kumar", "DCM Colony");

        session.beginTransaction();

        session.persist(customer1);
        session.persist(customer2);
        session.persist(customer3);
        session.persist(customer4);
        session.persist(customer5);
        session.persist(customer6);
        session.persist(customer7);
        session.persist(customer8);
        session.persist(customer9);

        session.getTransaction().commit();

        System.out.println("*********SQL SELECT***********");
        Query query = session.getNamedQuery("sql_select");
        List list = query.list();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object[] object = (Object[]) iterator.next();
            System.out.println("cId : " + object[0] + " cName : " + object[1] + " cCity : " + object[2]);
        }

        System.out.println("*********sql_select_with_param***********");
        Query query5 = session.getNamedQuery("sql_select_with_param").setString(1, "8");
        List list5 = query5.list();
        Iterator iterator5 = list5.iterator();
        while (iterator5.hasNext()) {
            Object[] object = (Object[]) iterator5.next();
            System.out.println("cId : " + object[0] + " cName : " + object[1] + " cCity : " + object[2]);
        }

        System.out.println("*********HQL SELECT***********");
        Query query2 = session.getNamedQuery("hql_select");
        List list2 = query2.list();
        Iterator iterator2 = list2.iterator();
        while (iterator2.hasNext()) {
            Customer customer = (Customer) iterator2.next();
            System.out.println("cId : " + customer.getCustomerId() + " cName : " + customer.getCustomerName()
                    + " cCity : " + customer.getCustomerCity());
        }

        System.out.println("*********hql_select_with_param***********");
        Query query3 = session.getNamedQuery("hql_select_with_param").setString("id", "1");
        List list3 = query3.list();
        Iterator iterator3 = list3.iterator();
        while (iterator3.hasNext()) {
            Customer customer = (Customer) iterator3.next();
            System.out.println("cId : " + customer.getCustomerId() + " cName : " + customer.getCustomerName()
                    + " cCity : " + customer.getCustomerCity());
        }

        System.out.println("*********hql_select_with_named_param***********");
        Query query4 = session.getNamedQuery("hql_select_with_named_param").setString("name", "Raj Kumar");
        List list4 = query4.list();
        Iterator iterator4 = list4.iterator();
        while (iterator4.hasNext()) {
            Customer customer = (Customer) iterator4.next();
            System.out.println("cId : " + customer.getCustomerId() + " cName : " + customer.getCustomerName()
                    + " cCity : " + customer.getCustomerCity());
        }
    }
}

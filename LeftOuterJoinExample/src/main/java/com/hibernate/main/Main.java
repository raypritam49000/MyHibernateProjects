package com.hibernate.main;

import com.hibernate.model.Customer;
import com.hibernate.model.Item;
import static com.hibernate.session.SessionProvider.getSession;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class Main {

    public static void main(String[] args) {
        Session session = getSession();
        session.beginTransaction();
        
        Customer customer = new Customer();
        customer.setCustomerId(123);
        customer.setCustomerName("Pritam Ray");
        customer.setCustomerCity("Prem Nagar");
        
        Item item1 = new Item(12,"Book", 500);
        Item item2 = new Item(123,"Laptop", 50000);
        Item item3 = new Item(312,"Mobile", 15000);
        List<Item>items = Arrays.asList(item1,item2,item3);
        
        customer.setItems(items);
        
        session.persist(customer);
        
        session.getTransaction().commit();
        
        Query qry= session.createQuery("select c.customerName, c.customerCity, i.itemName,i.price from Customer c "
                + "left join c.items i");
        
        List l = qry.list();
        
        Iterator it=l.iterator();
        while(it.hasNext())
        {
            Object rows[] = (Object[])it.next();
            System.out.println(rows[0]+ " -- " +rows[1] + " -- "+rows[2]+" -- "+rows[3]);
        }
        session.clear();
        session.close();
    }

}
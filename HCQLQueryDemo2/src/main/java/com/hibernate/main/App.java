package com.hibernate.main;

import com.hibernate.model.Customer;
import com.hibernate.model.Item;
import com.hibernate.session.SessionProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

public class App {

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);
        
        Customer customer = new Customer();
        customer.setCustomerId(233);
        customer.setCustomerCity("Ropar");
        customer.setCustomerName("Pritam Ray");
        
        List<Item> items = new ArrayList<>();
        items.add(new Item(123,"Hp LapTop",45000));
        items.add(new Item(163,"Dell LapTop",35000));
        items.add(new Item(223,"Asus LapTop",55000));
        
        customer.setItems(items);
        
        session.beginTransaction();
        
        session.save(customer);
        
        Query query = session.createQuery("select c.customerName, c.customerCity, i.itemName,i.price from Customer c "
                + "left join c.items i");
        
        List l = query.getResultList();
        Iterator it=l.iterator();
        while(it.hasNext())
        {
            Object rows[] = (Object[])it.next();
            System.out.println(rows[0]+ " -- " +rows[1] + "--"+rows[2]+"--"+rows[3]);
        }
        
        session.getTransaction().commit();
        session.clear();
        session.close();

    }

}

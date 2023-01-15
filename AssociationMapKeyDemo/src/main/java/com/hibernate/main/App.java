package com.hibernate.main;

import com.hibernate.model.Item;
import com.hibernate.model.Order;
import com.hibernate.session.SessionProvider;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {
       System.out.println("Starting the Project....");
       Session session = SessionProvider.getSession();
       System.out.println(session);
       
       Item item = new Item();
       item.setItemName("Laptop");
       item.setItemPrice(23900.22);
       
       Item item1 = new Item();
       item1.setItemName("Book");
       item1.setItemPrice(200.22);
       
       Item item2 = new Item();
       item2.setItemName("Mobile");
       item2.setItemPrice(15000.22);
       
       Map<String,Item> map = new HashMap<>();
       map.put("item1", item);
       map.put("item2", item1);
       map.put("item3", item2);
       
       Order order = new Order();
       order.setItemMap(map);
       
       Transaction transaction = session.beginTransaction();
       session.save(order);
       transaction.commit();
        System.out.println("Projects are run sucessfully....");
    }
}

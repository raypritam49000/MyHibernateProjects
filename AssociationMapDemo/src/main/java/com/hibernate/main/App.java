package com.hibernate.main;

import com.hibernate.model.Order;
import com.hibernate.session.SessionProvider;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {
       Session session = SessionProvider.getSession();
       System.out.println(session);
       
       Map<String,Double> itemPriceMap = new HashMap<String,Double>();
       itemPriceMap.put("Book", 456.8);
       itemPriceMap.put("Laptop", 44456.8);
       itemPriceMap.put("Mobile", 12456.8);
       
       Order order = new Order();
       order.setItemPriceMap(itemPriceMap);
       
       Transaction transaction = session.beginTransaction();
       
       session.save(order);
        
       transaction.commit();
       
    }
}

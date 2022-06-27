package com.hibernate.main;

import com.hibernate.model.Item;
import com.hibernate.model.ItemType;
import com.hibernate.model.Order;
import com.hibernate.model.Seller;
import com.hibernate.session.SessionProvider;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.Session;

public class App {
    public static void main(String[] args) {
        System.out.println("Starting the Projects.......");
        Session session = SessionProvider.getSession();
        System.out.println(session);
        
        Seller seller1 = new Seller();
        seller1.setSellerName("Pritam Ray");
        
        Item item2 = new Item();
        item2.setItemName("HP Model");
        item2.setItemPrice(20000.00);
        item2.setItemType(ItemType.LAPTOP);
        item2.setCreatedOn(new Date());
        
        Seller seller2 = new Seller();
        seller2.setSellerName("Omi Verma");
        
        Item item1 = new Item();
        item1.setItemName("MI MOBILE");
        item1.setItemPrice(12000.00);
        item1.setItemType(ItemType.MOBILE);
        item1.setCreatedOn(new Date());
        
        item1.setSeller(seller1);
        item2.setSeller(seller2);
        
        Map<Seller,Item> sellerItemMap = new HashMap<>();
        sellerItemMap.put(seller1, item1);
        sellerItemMap.put(seller2, item2);
        
        Order order = new Order();
        order.setSellerItemMap(sellerItemMap);
        
        session.beginTransaction();
        session.save(order);
        session.save(seller1);
        session.save(seller2);
        session.save(item1);
        session.save(item2);
        
        session.getTransaction().commit();
        System.out.println("Projects are run sucessfully.....");
        
    }
 
}

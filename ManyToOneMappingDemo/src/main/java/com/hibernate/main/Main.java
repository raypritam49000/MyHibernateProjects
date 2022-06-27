package com.hibernate.main;

import com.hibernate.model.Customer;
import com.hibernate.model.Item;
import com.hibernate.session.SessionProvider;
import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {
        System.out.println("Starting the Projects........");
        Session session = SessionProvider.getSession();
        Customer customer = new Customer(1002,"Pritam Ray","Ropar");
        
        Item i1 = new Item(901,"Samsung",9000,customer);

        Item i2 = new Item(902,"LG",6000,customer);
        Item i3 = new Item(9102,"LG",6000,customer);

          session.beginTransaction();
          
          session.save(i1);
          session.save(i2);
          session.save(i3);
          
         session.getTransaction().commit();
         System.out.println("Projects are run sucessfully...... ");
    }
}


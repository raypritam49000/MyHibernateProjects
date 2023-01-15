package com.hibernate.main;

import com.hibernate.model.Book;
import com.hibernate.session.SessionProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {
        System.out.println("Starting the Project......");
        Session session = SessionProvider.getSession();
        System.out.println(session);
        
        Book b = new Book();
        b.setTitle("Hibernate Tips");
        b.setTopics(new String[]{"Java Persistence", "Hibernate"});  
        
        Transaction transaction = session.beginTransaction();
        session.persist(b);
        transaction.commit();
        System.out.println("Projects are run sucessfully........");
    }
 
}

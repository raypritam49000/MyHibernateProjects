package com.hibernate.session;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SessionPovider {
     public static Session getSession(){
       return new Configuration().configure().buildSessionFactory().openSession();
     }   
}

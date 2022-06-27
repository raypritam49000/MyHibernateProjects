package com.hibernate.session;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SessionProvider 
{
   public static Session session;
   
    public static Session getSession()
    {
        if(session==null)
        {
            session = new Configuration().configure().buildSessionFactory().openSession();
            return session;
        }
        else
        {
            return session;
        }
    }
}

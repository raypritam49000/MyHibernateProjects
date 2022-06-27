package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
       Configuration cfg = new Configuration();
       System.out.println(cfg);
       cfg.configure("hibernate.cfg.xml");
       
       SessionFactory sf = cfg.buildSessionFactory();
       System.out.println(sf);
       
       Session s = sf.openSession();
       System.out.println(s);
       
       Cheque cheque = new Cheque();
       cheque.setAmount(2000);
       cheque.setChequeType("SBI PLATINUM CARD");
       
       CreditCard creditCard = new CreditCard();
       creditCard.setAmount(12000);
       creditCard.setCreditCardType("HDFC CREDIT CARD");
       
       Transaction transaction =s.beginTransaction();
       
       s.save(cheque);
       s.save(creditCard);
       
       transaction.commit();
       
    }
}

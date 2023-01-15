package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		System.out.println(session);
		
		Student st = new Student();
		st.setName("Pritam Ray");
		
		Address ad = new Address();
		ad.setCity("Ropar");
		ad.setStreet("535");
		ad.setCountry("India");
		
		st.setAddress(ad);
		
		session.save(st);
		session.beginTransaction().commit();
    }
}

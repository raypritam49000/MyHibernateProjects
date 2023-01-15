package com.hibernate.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	System.out.println("Project Starting....");
		Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
        System.out.println(session);
        
        Student st = new Student("Pritam Ray","8699535682");
        
        Address add = new Address();
        add.setStreet("Punjab");
        add.setCity("Ropar");
        add.setAddedDate(new Date());
        add.setOpen(true);
        add.setX(233.43);
        
        FileInputStream fin = null;
        
        try 
        {
		    fin = new FileInputStream("src/main/java/user.png");
			byte[] data = new byte[fin.available()];
			fin.read(data);
			add.setImage(data);
		} 
        catch (Exception e)
        {
			e.printStackTrace();
		}
        finally {
		   fin.close();	
		}
        
        session.save(st);
        session.save(add);
        
        
       Transaction transaction = session.beginTransaction();
       transaction.commit();
       
       Student st1 = (Student)session.get(Student.class,1);
       System.out.println(st1.getName());
       
       Student st2 = (Student)session.load(Student.class,1);
       System.out.println(st2.getName());
       session.close();
       System.out.println("Project Done....");
    }     
}

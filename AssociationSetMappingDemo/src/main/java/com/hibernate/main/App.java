package com.hibernate.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Phone;
import com.hibernate.model.Student;
import com.hibernate.session.SessionProvider;

public class App {
	public static void main( String[] args )
    {
    	Session session = SessionProvider.getSession();
        System.out.println(session );
        
        Transaction transaction = session.beginTransaction();
        
        Phone phone1 = new Phone("house","32354353");
        Phone phone2 = new Phone("mobile","9889343423");
        
        Set<Phone> phoneNumbers = new HashSet<Phone>();
        phoneNumbers.add(phone1);
        phoneNumbers.add(phone2);
        
        Student student = new Student("Eswar", phoneNumbers);
        
        session.save(student);
        
        transaction.commit();
       

        
    }
}

package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Address;
import com.hibernate.model.Marks;
import com.hibernate.model.Person;
import com.hibernate.session.SessionProvider;

public class App 
{
    public static void main( String[] args )
    {
       Session session = SessionProvider.getSession();
       System.out.println(session);
       
       Person person = new Person();
       person.setName("Omi Verma");
       
       Address address = new Address();
       address.setCity("Ropar");
       address.setState("Punjab");
       address.setCountry("India");
       
       Marks marks = new Marks();
       marks.setEnglish_marks(89);
       marks.setHindi_marks(90);
       marks.setPunjabi_marks(145);
       
       person.setAddress(address);
       person.setMarks(marks);
       
       Transaction transaction = session.beginTransaction();
       
       session.save(person);
       
       transaction.commit();
       
    }
}

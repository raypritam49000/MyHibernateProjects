package com.hibernate.main;

import com.hibernate.model.Passport;
import com.hibernate.model.Person;
import com.hibernate.session.SessionProvider;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);
        
       
        Person person = new Person();
        person.setPersonId(1001);
        person.setPersonName("Chandrashekhar");

        Passport passport = new Passport();
        passport.setPassportNumber(12346856);
        passport.setExpireDate(new Date());
        passport.setIssudDate(new Date());
        passport.setPerson(person);

        Transaction transaction = session.beginTransaction();
        session.save(passport);
        transaction.commit();

        session.close();
    }
  
}

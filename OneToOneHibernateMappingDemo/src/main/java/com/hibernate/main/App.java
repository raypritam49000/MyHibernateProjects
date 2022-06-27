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
        person.setPersonId(1002);
        person.setPersonName("ChandraShekhar Goka");

        Passport passport = new Passport();
        passport.setPassportNumber(852963147);
        passport.setExpireDate(new Date());
        passport.setIssudDate(new Date());
        
        passport.setPerson(person);

        Transaction transaction = session.beginTransaction();
        session.save(passport);
        transaction.commit();

        session.close();
    }
  
}

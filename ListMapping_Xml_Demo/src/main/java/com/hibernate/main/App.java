package com.hibernate.main;

import com.hibernate.model.Emp;
import com.hibernate.session.SessionProvider;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);

        Emp e = new Emp();
        e.setName("Pritam Ray");
        
        Emp e1 = new Emp();
        e1.setName("Omi Verma");
        
        ArrayList<Object> l = new ArrayList<>();
        l.add("123412470");
        l.add("987658979");
        
        ArrayList<Object> l1 = new ArrayList<>();
        l1.add("1234567890");
        l1.add("9876543210");
        
        e.setMob(l);
        e1.setMob(l1);

        Transaction tx = session.beginTransaction();
        session.save(e);
        session.save(e1);
        
        tx.commit();
    }

}

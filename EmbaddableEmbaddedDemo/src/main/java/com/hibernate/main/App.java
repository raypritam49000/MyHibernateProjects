package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Address;
import com.hibernate.model.Marks;
import com.hibernate.model.Student;
import com.hibernate.session.SessionProvider;

public class App 
{
    public static void main( String[] args )
    {
        Session session = SessionProvider.getSession();
        System.out.println(session);
        
        Student st = new Student();
        st.setStudent_name("Pritam Ray");
        st.setStudent_mobile("8699535682");
        
        Address add = new Address();
        add.setStudent_city("Ropar");
        add.setStudent_state("Punjab");
        add.setStudent_country("India");
        
        Marks marks = new Marks();
        marks.setEnglish_marks(78);
        marks.setHindi_marks(89);
        marks.setPunjabi_marks(120);
        
        st.setAddress(add);
        st.setMarks(marks);
        
        Transaction transaction = session.beginTransaction();
        
        session.save(st);
        
        transaction.commit();
    }
}

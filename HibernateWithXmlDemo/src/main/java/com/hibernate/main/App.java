package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.core.hibernate.model.Employee;
import com.core.hibernate.model.Student;
import com.hibernate.session.SessionProvider;

public class App 
{
    public static void main( String[] args )
    {
      
     Session session = SessionProvider.getSession();
     System.out.println(session);
     
     Student st = new Student();
     st.setId(122);
     st.setName("Pritam Ray");
     st.setAge(24);
     st.setMobile(8699535682l);
     
     Employee emp = new Employee();
     emp.setId(1234);
     emp.setName("Raj Kumar");
     
     Transaction t = session.beginTransaction();
     session.save(st);
     session.save(emp);
     t.commit();
     
      
    }
}

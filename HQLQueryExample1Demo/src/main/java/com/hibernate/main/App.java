package com.hibernate.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hiberanate.bean.Student;
import com.hiberanate.session.SessionProvider;

public class App 
{
    public static void main( String[] args )
    {
       Session session = SessionProvider.getSession();
       
       Student st = new Student();
       st.setId(123);
       st.setName("Pritam Ray");
       st.setAge(18);
       st.setMobile(8699535682l);
       
       Student st1 = new Student();
       st1.setId(127);
       st1.setName("Omi Verma");
       st1.setAge(34);
       st1.setMobile(7658848384l);
       
       session.save(st);
       session.save(st1);
       
       Transaction transaction = session.beginTransaction();
       transaction.commit();
       
       String query = "from Student as s where s.id=:y and s.age=:x";
       Query q =session.createQuery(query);
       q.setParameter("y",127);
       q.setParameter("x",34);
       
       List<Student> list = q.list();
       
       for(Student student : list) 
       {
    	   System.out.println(student.getId()+" "+student.getName()+" "+student.getAge()+" "+student.getMobile());
       }
    }
}

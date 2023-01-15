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
       
       Student st2 = new Student();
       st2.setId(12);
       st2.setName("Chandan Kumar");
       st2.setAge(31);
       st2.setMobile(78882333232l);
       
       Student st3 = new Student();
       st3.setId(177);
       st3.setName("Vikas Kumar");
       st3.setAge(24);
       st3.setMobile(7658844344l);
       
       session.save(st);
       session.save(st1);
       session.save(st2);
       session.save(st3);
       
       Transaction transaction = session.beginTransaction();
       
       
       String query = "from Student as s where s.id=:y and s.age=:x";
       Query q =session.createQuery(query);
       q.setParameter("y",127);
       q.setParameter("x",34);
       
       List<Student> list = q.list();
       
       for(Student student : list) 
       {
    	   System.out.println(student.getId()+" "+student.getName()+" "+student.getAge()+" "+student.getMobile());
       }
       
       System.out.println();
       System.out.println("....Update The Hibernate....");
       
       Query q2 = session.createQuery("update Student set name='Suraj Mehta' where id=:c");
       q2.setParameter("c",12);
       
       int i = q2.executeUpdate();
       System.out.println(i);
       System.out.println("....Update Sucessfully....");
       
       System.out.println();
       System.out.println("...Delete The Hibernate....");
       
       Query q3 = session.createQuery("delete from Student s where s.id=:a and s.age=:b");
       q3.setParameter("a",127);
       q3.setParameter("b",34);
       
       int value = q3.executeUpdate();
       System.out.println(".....Delete Sucessful....");
       System.out.println(value);
       
       transaction.commit();
    }
}


package com.hibernate.main.dto;

import com.hibernate.main.model.Teacher;
import com.hibernate.main.session.SessionProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TeacherDto {
    
  public static void insertTeacher(Teacher teacher)
  {
      Session session = SessionProvider.getSession();
      teacher.setName("Raj Kumar");
      teacher.setAge(23);
      Transaction transaction = session.beginTransaction();
      session.save(teacher);
      transaction.commit();
  }  
  
   public static void updateTeacher(Teacher teacher)
  {
      Session session = SessionProvider.getSession();
      Transaction transaction = session.beginTransaction();
      Teacher teacher1 = (Teacher)session.byId(Teacher.class).getReference(teacher.getId());
      teacher1.setName("Chandan Kumar");
      teacher1.setAge(37);
      session.save(teacher);
      transaction.commit();
  } 
   
    public static void deleteTeacher(Teacher teacher)
  {
      Session session = SessionProvider.getSession();
      Transaction transaction = session.beginTransaction();
      session.delete(teacher);
      transaction.commit();
  } 
}

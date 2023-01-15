package com.hibernate.main.dao;

import com.hibernate.main.model.Teacher;
import com.hibernate.main.session.SessionProvider;
import org.hibernate.Session;

public class TeacherDao {
    
    public static void getTeacher(Teacher teacher){
       Session session = SessionProvider.getSession();
       Teacher teacher1 = session.byId(Teacher.class).getReference(teacher.getId());
        System.out.println("Teacher ID :- "+teacher1.getName());
        System.out.println("Teacher Name :- "+teacher1.getName());
        System.out.println("Teacher Age :- "+teacher1.getAge());
    }
}

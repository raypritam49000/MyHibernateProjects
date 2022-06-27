package com.core.hibernate.main;

import com.core.hibernate.beans.Student;
import com.core.hibernate.dao.StudentDao;

public class App 
{
    public static void main( String[] args )
    {
        Student student = new Student("Ram","Raj","raju@gmail.com");
        StudentDao stdao = new StudentDao();
        stdao.saveStudent(student);
        System.out.println(student.getId());
    }
}

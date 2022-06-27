package com.core.hibernate.main;

import com.core.hibernate.model.Student;

import java.util.List;

import com.core.hibernate.dao.StudentDao;

public class App 
{
    public static void main( String[] args )
    {
        Student student = new Student("Ram","Raj","raju@gmail.com");
        
        //test saveStudent
        StudentDao studentDao = new StudentDao();
        studentDao.saveStudent(student);
        
        // test UpdateStudent
        student.setFirstName("Pritam Ray");
        studentDao.updateStudent(student);
        
        //test getStudentById
        Student student2 =  studentDao.getStudentById(student.getId());
         
        //test getAllStudents
        List<Student> students = studentDao.getAllStudent();
        students.forEach(student1 -> System.out.println(student1.getId()));
        
        //test deleteStudent
        studentDao.deleteStudent(student.getId());
    }
}

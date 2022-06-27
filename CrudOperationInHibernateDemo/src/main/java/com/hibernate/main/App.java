package com.hibernate.main;

import java.util.List;

import com.hibernate.dao.StudentDao;
import com.hibernate.model.Student;

public class App {

	public static void main(String[] args) 
	{
		StudentDao studentDao = new StudentDao();
		
		// test saveStuent
		Student student = new Student(12,"Pritam Ray","pray@gmail.com");
		
		//test UpdateStudent
		student.setName("Omi Verma");
		studentDao.updateStudent(student);
		
		studentDao.saveStudent(student);
		//test getStudentById
		Student student2 = studentDao.getStudentById(student.getId());
		
		//test getAllStudent
		List<Student> students = studentDao.getAllStudents();
		students.forEach(student1 -> System.out.println(student1.getId()));
		
		//test delete student
		studentDao.deleteStudent(student.getId());
	}

}

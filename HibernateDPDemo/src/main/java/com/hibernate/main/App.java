package com.hibernate.main;

import java.util.Scanner;

import com.hibernate.dao.StudentDao;
import com.hibernate.dto.StudentDto;
import com.hibernate.model.Student;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Name : ");
		String name = sc.nextLine();
		System.out.println("Enter the Address : ");
		String address = sc.nextLine();
		System.out.println("Enter the Age : ");
		int age = sc.nextInt();
		
		Student student = new Student(name,address,age);
		StudentDto.studentRegister(student);
		StudentDao.getStudent(student);

	}
}

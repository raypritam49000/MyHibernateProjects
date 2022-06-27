package com.core.hibernate.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.core.hibernate.beans.Student;
import com.core.hibernate.util.HibernateUtil;

public class App {
	
	public void insertInfo() {
		Transaction transaction = null;
		try 
		{
			Session session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			Student student = new Student();
			student.setFirstName("Pritam");
			student.setLastName("Ray");
			student.setEmail("Ray@gmail.com");
			session.save(student);
			System.out.println("Object save succesfully");
			
			transaction.commit();
	    } 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	
	public void getInfo() {
		Transaction transaction = null;
		try 
		{
			Session session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			Object ob = session.load(Student.class,new Integer(1));
			Student student = (Student) ob;
			System.out.println("FirstName :- "+student.getFirstName());
			System.out.println("lastName :- "+student.getLastName());
			System.out.println("Email :- "+student.getEmail());
			transaction.commit();
			System.out.println("Get the Data Successfully...");
	    } 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	
	public void updateInfo() {
		Transaction transaction = null;
		try 
		{
			Session session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			Object ob = session.load(Student.class,new Integer(1));
			Student student = (Student) ob;
			student.setFirstName("Omi");
			student.setLastName("Verma");
			student.setEmail("pray4900@gmail.com");
			transaction.commit();
			System.out.println("Object are successfully update...");
	    } 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	
	
	public void updateInfo1() {
		Transaction transaction = null;
		try 
		{
			Session session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			Student student = new Student();
			student.setFirstName("Chandan");
			student.setLastName("Kumar");
			student.setEmail("ram@gmail.com");
			session.update(student);
			transaction.commit();
			System.out.println("Object are update sucessfully...");
	    } 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	
	

	public void deleteInfo() {
		Transaction transaction = null;
		try 
		{
			Session session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			Object ob = session.load(Student.class,new Integer(1));
			Student student = (Student) ob;
			session.delete(student);
			transaction.commit();
			System.out.println("Object are delete sucessfully...");
	    } 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	
	
	public static void main(String[] args) {
		
		App app = new App();
		
		app.insertInfo();
		app.getInfo();
		
		app.updateInfo();
		app.getInfo();
		
		//app.updateInfo1();
		//app.getInfo();
		
		app.deleteInfo();
		//app.getInfo();
		
		
	}
}

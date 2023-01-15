package com.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Student;
import com.hibernate.util.HibernateUtil;

public class StudentDao 
{
    //saveStudent,get All Student,get Student By Id,Update Student,Delete Student
	
	public  void saveStudent(Student student) 
	{
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) 
		{
			// start the transaction
		    transaction = session.beginTransaction();
		    
			// save the studnet object
			session.save(student);
						
			//commit the transaction
			transaction.commit();
			
		}
		catch (Exception e) 
		{
			if(transaction!=null) 
			{
				transaction.rollback();
			}
		}
	}
	
	
	public  Student updateStudent(Student student) 
	{
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) 
		{
			// start the transaction
		    transaction = session.beginTransaction();
		    
			// get studnet object
			session.saveOrUpdate(student);
						
			//commit the transaction
			transaction.commit();
			
		}
		catch (Exception e) 
		{
			if(transaction!=null) 
			{
				transaction.rollback();
			}
		}
		return student;
	}
	
	public  Student getStudentById(long id) 
	{
		Transaction transaction = null;
		Student student = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) 
		{
			// start the transaction
		    transaction = session.beginTransaction();
		    
			// get studnet object
			student = session.get(Student.class, id);
			//student = session.load(Student.class, id);
						
			//commit the transaction
			transaction.commit();
			
		}
		catch (Exception e) 
		{
			if(transaction!=null) 
			{
				transaction.rollback();
			}
		}
		return student;
	}
	
	//@SuppressWarnings
	public List<Student> getAllStudents() 
	{
		Transaction transaction = null;
		List<Student> students = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) 
		{
			// start the transaction
		    transaction = session.beginTransaction();
		    
			// save the studnet object
			students = session.createQuery("from Student").list();
						
			//commit the transaction
			transaction.commit();
			
		}
		catch (Exception e) 
		{
			if(transaction!=null) 
			{
				transaction.rollback();
			}
		}
		return students;
	}
	
	
	public  void deleteStudent(long id) 
	{
		Transaction transaction = null;
		Student student = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) 
		{
			// start the transaction
		    transaction = session.beginTransaction();
		    
			// get student object
		    student = session.get(Student.class, id);
		    
		    //delete data
		    session.delete(student);
						
			//commit the transaction
			transaction.commit();
			
		}
		catch (Exception e) 
		{
			if(transaction!=null) 
			{
				transaction.rollback();
			}
		}
	}
}

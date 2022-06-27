package com.core.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.core.hibernate.beans.Student;
import com.core.hibernate.util.HibernateUtil;

public class StudentDao 
{
	public void saveStudent(Student student) 
	{
		Transaction transaction = null;
		try(Session session = HibernateUtil.getsessionFactory().openSession()) 
		{
			// start the transaction
		   transaction = session.beginTransaction();
		   
		   // save the student object
		   session.save(student);
		   
		   // commit the transaction
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

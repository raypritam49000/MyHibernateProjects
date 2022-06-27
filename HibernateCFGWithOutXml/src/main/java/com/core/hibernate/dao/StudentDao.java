package com.core.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.core.hibernate.model.Student;
import com.core.hibernate.util.HibernateUtil;

public class StudentDao {
	
	public void saveStudent(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getsessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();

			// save the student object
			session.save(student);

			// commit the transaction
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	public void updateStudent(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getsessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();

			// save or update the student object
			session.saveOrUpdate(student);

			// commit the transaction
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	public Student getStudentById(int id) {
		Transaction transaction = null;
		Student student = null;
		try (Session session = HibernateUtil.getsessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();

			// get student object
			 student = session.get(Student.class, id);

			// commit the transaction
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return student;
	}
	
	public List<Student> getAllStudent() {
		Transaction transaction = null;
		List<Student> students = null;
		try (Session session = HibernateUtil.getsessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();

			// get list of all student 
			 students = session.createQuery("from Student").list();

			// commit the transaction
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return students ;
	}
	
	public void deleteStudent(int id) {
		Transaction transaction = null;
		Student student = null;
		try (Session session = HibernateUtil.getsessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();

			// get student by id 
			 student = session.get(Student.class,id);
			 
			 // delete student object
			 session.delete(student);

			// commit the transaction
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}


}

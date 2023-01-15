package com.hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.bean.Applicant;
import com.hibernate.session.SessionProvider;

public class CrudOpertion {
	public static void main(String[] args) {

		Session session = SessionProvider.getSession();

		Transaction t = session.beginTransaction();

		Applicant applicant1 = new Applicant();
		applicant1.setFirstName("John");
		applicant1.setLastName("KC");
		applicant1.setAge(28);
		applicant1.setEducation("Graduation");

		Applicant applicant2 = new Applicant();
		applicant2.setFirstName("Jacob");
		applicant2.setLastName("JC");
		applicant2.setAge(30);
		applicant2.setEducation("Graduation");

		session.save(applicant1);
		session.save(applicant2);
		System.out.println("successfully persisted Applicant details");

		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("from Applicant");

		List<Applicant> list = query.getResultList();
		System.out.println("Number of Applicants present--> " + list.size());

		for (Applicant applicant : list) {

			System.out.println(applicant.getApplicantId());
			System.out.println(applicant.getFirstName());
		}

		Query query1 = session.createQuery("update Applicant set age=:age where id=:id");
		query1.setParameter("age", 30);
		query1.setParameter("id", 1);
		
		int result = query1.executeUpdate();
		System.out.println("No of rows updated: " + result);
		
		
		Query query2 = session.createQuery("insert into ApplicantBackup (applicantId,firstName,lastName,age,education)select id, firstName,lastName,age,education from Applicant");
		int result1 = query2.executeUpdate();
        System.out.println("No of rows inserted: "+result1);
        
        Query query3 = session.createQuery("delete from ApplicantBackup where id=:id");
        query3.setParameter("id", 1);
        int result2 = query3.executeUpdate();
        System.out.println("No of rows Deleted: "+result);
       
		t.commit();

		session.close();

	}

}
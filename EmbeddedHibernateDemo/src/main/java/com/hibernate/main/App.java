package com.hibernate.main;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Address;
import com.hibernate.model.Person;
import com.hibernate.session.SessionProvider;

public class App {

	public static void main(String[] args) {

		Session session = SessionProvider.getSession();
		Transaction tx = session.beginTransaction();

		Address address = new Address("Prem Nagar","Ropar","144533","Punjab");
		Person person = new Person("Pritam Ray", address);

		session.save(person);
		tx.commit();

		List<Person> activities = session.createQuery("from Person").list();
		System.out.println(Arrays.toString(activities.toArray()));

		session.close();

	}

}

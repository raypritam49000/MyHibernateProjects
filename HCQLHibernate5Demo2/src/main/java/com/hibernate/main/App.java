package com.hibernate.main;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Person;
import com.hibernate.session.SessionProvider;

public class App {
	public static void main(String[] args) {
		Session session = SessionProvider.getSession();
		System.out.println(session);

		Person person1 = new Person("Pritam Ray", "ray123@gmail.com", 23, 8699535682l);
		Person person2 = new Person("Omi Verma", "omiverma434@gmail.com", 32, 7696889454l);
		Person person3 = new Person("Chandan Kumar", "Chandan876@gmail.com", 30, 5443323222l);
		Person person4 = new Person("Ram Kumar", "ram435@gmail.com", 34, 7009842343l);

		Transaction transaction = session.beginTransaction();
		session.save(person1);
		session.save(person2);
		session.save(person3);
		session.save(person4);

		transaction.commit();

		// select name from person;
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
		Root<Person> root = criteriaQuery.from(Person.class);
		criteriaQuery.select(root.get("name"));

		Query<String> query = session.createQuery(criteriaQuery);
		List<String> persons = query.getResultList();
		for (String person : persons) {
			System.out.println(person);
		}
	}
}

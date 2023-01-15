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

		Person person1 = new Person("Pritam Ray", "ray123@gmail.com", 23, 8699535682l, 23000.43);
		Person person2 = new Person("Omi Verma", "omiverma434@gmail.com", 32, 7696889454l, 34500);
		Person person3 = new Person("Chandan Kumar", "Chandan876@gmail.com", 30, 5443323222l, 45000);
		Person person4 = new Person("Ram Kumar", "ram435@gmail.com", 34, 7009842343l, 67000);
		Person person5 = new Person("Pritam Ray", "ray123@gmail.com", 23, 8699535682l, 23000.43);
		Person person6 = new Person("Omi Verma", "omiverma434@gmail.com", 32, 7696889454l, 34500);

		Transaction transaction = session.beginTransaction();
		session.save(person1);
		session.save(person2);
		session.save(person3);
		session.save(person4);
		session.save(person5);
		session.save(person6);

		transaction.commit();

		CriteriaBuilder builder = session.getCriteriaBuilder();

		// Count number of employees
		CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
		Root<Person> root = criteriaQuery.from(Person.class);
		criteriaQuery.select(builder.count(root));
		Query<Long> query = session.createQuery(criteriaQuery);
		long count = query.getSingleResult();
		System.out.println("Count = " + count);

		// Get max salary
		CriteriaQuery<Double> criteriaQuery2 = builder.createQuery(Double.class);
		Root<Person> root2 = criteriaQuery2.from(Person.class);
		criteriaQuery2.select(builder.max(root2.get("salary")));
		Query<Double> query2 = session.createQuery(criteriaQuery2);
		double maxSalary = query2.getSingleResult();
		System.out.println("Max Salary = " + maxSalary);

		// Get Average Salary
		CriteriaQuery<Double> criteriaQuery3 = builder.createQuery(Double.class);
		Root<Person> root3 = criteriaQuery3.from(Person.class);
		criteriaQuery3.select(builder.avg(root3.get("salary")));
		Query<Double> query3 = session.createQuery(criteriaQuery3);
		double avgSalary = query3.getSingleResult();
		System.out.println("Average Salary = " + avgSalary);

		// Count distinct employees
		CriteriaQuery<Long> criteriaQuery4 = builder.createQuery(Long.class);
		Root<Person> root4 = criteriaQuery4.from(Person.class);
		criteriaQuery4.select(builder.countDistinct(root4));
		Query<Long> query4 = session.createQuery(criteriaQuery4);
		long distinct = query4.getSingleResult();
		System.out.println("Distinct count = " + distinct);

	}
}

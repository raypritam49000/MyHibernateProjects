package com.hibernate.main;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Person;
import com.hibernate.session.SessionProvider;

public class App {
	public static Session session;

	public static void getTotalPerson() {
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<Person> root = criteriaQuery.from(Person.class);
		criteriaQuery.select(criteriaBuilder.count(root));

		Query<Long> query = session.createQuery(criteriaQuery);
		List<Long> counts = query.getResultList();
		for (Long count : counts) {
			System.out.println("Total No of Persons : " + count);
		}
	}

	public static void getTotalSalary() {
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Double> criteriaQuery = criteriaBuilder.createQuery(Double.class);
		Root<Person> root = criteriaQuery.from(Person.class);
		criteriaQuery.select(criteriaBuilder.sum(root.get("salary")));
		TypedQuery<Double> query = session.createQuery(criteriaQuery);
		List<Double> sum = query.getResultList();
		for (Double sums : sum) {
			System.out.println("Total Salary : " + sums);
		}
	}

	public static void getMaxSalary() {
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Double> criteriaQuery = criteriaBuilder.createQuery(Double.class);
		Root<Person> root = criteriaQuery.from(Person.class);
		criteriaQuery.select(criteriaBuilder.max(root.get("salary")));
		TypedQuery<Double> query = session.createQuery(criteriaQuery);
		List<Double> sum = query.getResultList();
		for (Double sums : sum) {
			System.out.println("Max Salery : " + sums);
		}
	}

	public static void getMinSalary() {
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Double> criteriaQuery = criteriaBuilder.createQuery(Double.class);
		Root<Person> root = criteriaQuery.from(Person.class);
		criteriaQuery.select(criteriaBuilder.min(root.get("salary")));
		TypedQuery<Double> query = session.createQuery(criteriaQuery);
		List<Double> sum = query.getResultList();
		for (Double sums : sum) {
			System.out.println("Min Salery : " + sums);
		}
	}

	public static void getAvgSalary() {
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Double> criteriaQuery = criteriaBuilder.createQuery(Double.class);
		Root<Person> root = criteriaQuery.from(Person.class);
		criteriaQuery.select(criteriaBuilder.avg(root.get("salary")));
		TypedQuery<Double> query = session.createQuery(criteriaQuery);
		List<Double> sum = query.getResultList();
		for (Double sums : sum) {
			System.out.println("Average Salery : " + sums);
		}
	}
	
	public static void getDistinctPerson() {
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<Person> root = criteriaQuery.from(Person.class);
		criteriaQuery.select(criteriaBuilder.countDistinct(root.get("name")));
		
		Query<Long> query = session.createQuery(criteriaQuery);
		List<Long> counts = query.getResultList();
		for (Long count : counts) {
			System.out.println("Total No of Distinct Persons : " + count);
		}
		
	}

	public static void getPersonById() {
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
		Root<Person> root = criteriaQuery.from(Person.class);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"), 3));

		TypedQuery<Person> query = session.createQuery(criteriaQuery);
		List<Person> persons = query.getResultList();
		for (Person person : persons) {
			System.out.println("Person Details : " + person);
		}

	}

	public static void main(String[] args) {
		session = SessionProvider.getSession();
		System.out.println(session);

		Person person1 = new Person("Pritam Ray", "ray123@gmail.com", 23, 8699535682l, 50000);
		Person person2 = new Person("Omi Verma", "omiverma434@gmail.com", 32, 7696889454l, 34000);
		Person person3 = new Person("Chandan Kumar", "Chandan876@gmail.com", 30, 5443323222l, 25000);
		Person person4 = new Person("Ram Kumar", "ram435@gmail.com", 34, 7009842343l, 60000);
		Person person5 = new Person("Raju Kumar", "raju823@gmail.com", 53, 8699765682l, 50000);
		Person person6 = new Person("Amit Kumar", "amit75434@gmail.com", 32, 76089889454l, 34000);
		Person person7 = new Person("Jp Verma", "jpverma876@gmail.com", 38, 54063523222l, 25000);
		Person person8 = new Person("Sadak Singh", "ram435@gmail.com", 44, 70007452343l, 60000);
		Person person9 = new Person("Pritam Ray", "ray123@gmail.com", 23, 8699535682l, 50000);
		Person person10 = new Person("Omi Verma", "omiverma434@gmail.com", 32, 7696889454l, 34000);
		Person person11 = new Person("Chandan Kumar", "Chandan876@gmail.com", 30, 5443323222l, 25000);
		Person person12 = new Person("Ram Kumar", "ram435@gmail.com", 34, 7009842343l, 60000);

		Transaction transaction = session.beginTransaction();
		session.save(person1);
		session.save(person2);
		session.save(person3);
		session.save(person4);
		session.save(person5);
		session.save(person6);
		session.save(person7);
		session.save(person8);
		session.save(person9);
		session.save(person10);
		session.save(person11);
		session.save(person12);

		transaction.commit();

		getTotalPerson();
		getTotalSalary();
		getMaxSalary();
		getMinSalary();
		getAvgSalary();
		getPersonById();
		getDistinctPerson();
	}
}

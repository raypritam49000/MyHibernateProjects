package com.hibernate.main;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.dto.PersonStatisticInfo;
import com.hibernate.model.Person;
import com.hibernate.session.SessionProvider;

public class App {
	public static void main(String[] args) {
		Session session = SessionProvider.getSession();
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

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<PersonStatisticInfo> criteriaQuery = criteriaBuilder.createQuery(PersonStatisticInfo.class);
		Root<Person> root = criteriaQuery.from(Person.class);

		Expression<Long> totalPerson = criteriaBuilder.count(root);
		Expression<Double> totalSalary = criteriaBuilder.sum(root.get("salary"));
		Expression<Double> maxSalary = criteriaBuilder.max(root.get("salary"));
		Expression<Double> minSalary = criteriaBuilder.min(root.get("salary"));
		Expression<Double> avgSalary = criteriaBuilder.avg(root.get("salary"));
		Expression<Long> distinctPerson = criteriaBuilder.countDistinct(root);

		criteriaQuery.select(criteriaBuilder.construct(PersonStatisticInfo.class, totalPerson, totalSalary, maxSalary,
				minSalary, avgSalary, distinctPerson));

		PersonStatisticInfo singleResult = session.createQuery(criteriaQuery).getSingleResult();
		System.out.println(singleResult);
	}
}

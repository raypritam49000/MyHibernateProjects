package com.hibernate.main;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.hibernate.beans.Employee;
import com.hibernate.session.SessionProvider;

public class App {
	public static void main(String[] args) {
		Session session = SessionProvider.getSession();
		System.out.println(session);

		Employee employee1 = new Employee("Pritam Ray", "Ropar", 55000);
		Employee employee2 = new Employee("Omi Verma", "Chandigarh", 15000);
		Employee employee3 = new Employee("Amit Kumar", "Prem Nagar", 25000);
		Employee employee4 = new Employee("Chandan Kumar", "Uk", 20000);
		Employee employee5 = new Employee("Raj Kumar", "Rail", 30000);
		Employee employee6 = new Employee("Suraj Mehta", "Nepal", 75000);
		Employee employee7 = new Employee("Ajit Kumar", "Asron", 45000);

		session.getTransaction().begin();

		session.save(employee1);
		session.save(employee2);
		session.save(employee3);
		session.save(employee4);
		session.save(employee5);
		session.save(employee6);
		session.save(employee7);

		session.getTransaction().commit();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> root = criteriaQuery.from(Employee.class);

		criteriaQuery.select(root);
		criteriaQuery.orderBy(criteriaBuilder.asc(root.get("salary")));

		TypedQuery<Employee> query = session.createQuery(criteriaQuery);
		List<Employee> employees = query.getResultList();

	}
}

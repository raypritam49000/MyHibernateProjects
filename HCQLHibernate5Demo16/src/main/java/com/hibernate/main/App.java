package com.hibernate.main;

import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.hibernate.model.Address;
import com.hibernate.model.Employee;
import com.hibernate.session.SessionProvider;

public class App {
	public static void main(String[] args) {
		Session session = SessionProvider.getSession();
		System.out.println(session);

		Employee employee = new Employee("Pritam", "Ray", "ray123@gmail.com", 24, 45000);
		Address address1 = new Address("Ropar", "Punjab", "India", "Asron");
		Address address2 = new Address("Prem Nagar", "Punjab", "India", "Asron");

		employee.setAddresses(Arrays.asList(address1, address2));
		address1.setEmployee(employee);
		address2.setEmployee(employee);

		session.getTransaction().begin();

		session.save(employee);
		session.save(address1);
		session.save(address2);

		session.getTransaction().commit();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Address> criteriaQuery = criteriaBuilder.createQuery(Address.class);
		Root<Address> root = criteriaQuery.from(Address.class);
		// root.join("employee", JoinType.INNER);
		root.fetch("employee");

		List<Address> list = session.createQuery(criteriaQuery).getResultList();

		for (Address add : list) {
			System.out.println(add.getId() + " " + add.getStreet() + " " + add.getCity() + " " + add.getState() + " "
					+ add.getCountry());
			Employee employee1 = add.getEmployee();
			System.out.println(employee1.getId() + " " + employee1.getFirstName() + " " + employee1.getLastName() + " "
					+ employee1.getSalary() +" "+ employee1.getEmail());
		}

	}
}

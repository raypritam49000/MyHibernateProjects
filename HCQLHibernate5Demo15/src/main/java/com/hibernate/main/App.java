package com.hibernate.main;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.hibernate.model.Address;
import com.hibernate.model.AddressJoin;
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
		CriteriaQuery<AddressJoin> criteriaQuery = criteriaBuilder.createQuery(AddressJoin.class);
		Root<Address> root = criteriaQuery.from(Address.class);
		root.join("employee", JoinType.INNER);

		criteriaQuery.select(criteriaBuilder.construct(AddressJoin.class, root.get("id"), root.get("city"),
				root.get("state"), root.get("employee").get("id"), root.get("employee").get("firstName"),
				root.get("employee").get("lastName"), root.get("employee").get("salary")

		));

		Query query = session.createQuery(criteriaQuery);
		List<AddressJoin> addressJoins = query.getResultList();
		
		for(AddressJoin addressJoin :addressJoins) {
			System.out.println("Id: " + addressJoin.getId());
			System.out.println("City: " + addressJoin.getCity());
			System.out.println("State: " + addressJoin.getState());
			System.out.println("Employee Id: " + addressJoin.getEmployeeId());
			System.out.println("Emolpyee First Name: " + addressJoin.getEmployeeFirstName());
			System.out.println("Emolpyee Last Name: " + addressJoin.getEmployeeLastName());
			System.out.println("Employee Salary : "+addressJoin.getEmployeeSalary());
			System.out.println("=======================");
		}

	}
}

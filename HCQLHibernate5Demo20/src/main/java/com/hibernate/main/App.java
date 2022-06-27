package com.hibernate.main;

import java.util.Arrays;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.hibernate.beans.Department;
import com.hibernate.beans.Employee;
import com.hibernate.session.SessionProvider;

public class App {
	public static void main(String[] args) {
		Session session = SessionProvider.getSession();
		System.out.println(session);

		Department department1 = new Department("IT", "Londan");

		Employee employee1 = new Employee("Pritam Ray", "Ropar", 55000);
		Employee employee2 = new Employee("Omi Verma", "Chandigarh", 15000);
		Employee employee3 = new Employee("Amit Kumar", "Prem Nagar", 25000);

		List<Employee> employees1 = Arrays.asList(employee1, employee2, employee3);
		department1.setEmployess(employees1);
		employee1.setDepartment(department1);
		employee2.setDepartment(department1);
		employee3.setDepartment(department1);

		Department department2 = new Department("IT", "Delhi");

		Employee employee4 = new Employee("Chandan Kumar", "Uk", 20000);
		Employee employee5 = new Employee("Raj Kumar", "Rail", 30000);
		Employee employee6 = new Employee("Suraj Mehta", "Nepal", 75000);
		Employee employee7 = new Employee("Ajit Kumar", "Asron", 45000);

		List<Employee> employees2 = Arrays.asList(employee4, employee5, employee6, employee7);
		department2.setEmployess(employees2);
		employee4.setDepartment(department2);
		employee5.setDepartment(department2);
		employee6.setDepartment(department2);
		employee7.setDepartment(department2);

		session.getTransaction().begin();

		session.save(department1);
		session.save(employee1);
		session.save(employee2);
		session.save(employee3);
		session.save(department2);
		session.save(employee4);
		session.save(employee5);
		session.save(employee6);
		session.save(employee7);

		session.getTransaction().commit();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
		Root<Employee> employeeRooT = criteriaQuery.from(Employee.class);
		Root<Department> departmentRoot = criteriaQuery.from(Department.class);

		criteriaQuery.multiselect(employeeRooT, departmentRoot);
		criteriaQuery.where(criteriaBuilder.equal(employeeRooT.get("department"), departmentRoot.get("id")));

		TypedQuery<Object[]> typedQuery = session.createQuery(criteriaQuery);
		List<Object[]> list = typedQuery.getResultList();

		for (Object[] obj : list) {
			Employee employee = (Employee) obj[0];
			System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getSalary());
			Department department = (Department) obj[1];
			System.out.println(department.getId()+" "+department.getName()+" "+department.getLocation());
		}
	}
}

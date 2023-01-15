package com.hibernate.main;

import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Department;
import com.hibernate.model.Employee;
import com.hibernate.session.SessionProvider;

public class App {
	public static void main(String[] args) {
		Session session = SessionProvider.getSession();
		System.out.println(session);

		Department department = new Department();
		department.setName("Ray Software Soutions");

		Employee employee1 = new Employee("Pritam Ray", "Ropar", 50000);
		Employee employee2 = new Employee("Omi Verma", "Rail", 56000);
		Employee employee3 = new Employee("Chandan Kumar", "Prem Nage", 45000);
		Employee employee4 = new Employee("Deepak Kumar", "Ropar", 30000);
		Employee employee5 = new Employee("Suraj Mehta", "RB Colony", 36000);
		Employee employee6 = new Employee("Raj Kumar", "Shive Mandir", 37000);

		List<Employee> employees = Arrays.asList(employee1, employee2, employee3, employee4, employee5, employee6);

		department.setEmployees(employees);
		employee1.setDepartment(department);
		employee2.setDepartment(department);
		employee3.setDepartment(department);
		employee4.setDepartment(department);
		employee5.setDepartment(department);
		employee6.setDepartment(department);

		Transaction transaction = session.beginTransaction();
		session.save(employee1);
		session.save(employee2);
		session.save(employee3);
		session.save(employee4);
		session.save(department);
		transaction.commit();

		CriteriaBuilder builder1 = session.getCriteriaBuilder();

		// Using FROM and JOIN
		CriteriaQuery<Object[]> criteriaQuery1 = builder1.createQuery(Object[].class);
		Root<Employee> empRoot = criteriaQuery1.from(Employee.class);
		Root<Department> deptRoot = criteriaQuery1.from(Department.class);
		criteriaQuery1.multiselect(empRoot, deptRoot);
		criteriaQuery1.where(builder1.equal(empRoot.get("department"), deptRoot.get("id")));

		Query<Object[]> query1 = session.createQuery(criteriaQuery1);
		List<Object[]> list1 = query1.getResultList();
		for (Object[] objects1 : list1) {
			Employee employee = (Employee) objects1[0];
			Department department1 = (Department) objects1[1];
			System.out.println("EMP NAME=" + employee.getName() + "\t DEPT NAME=" + department1.getName());
		}

		// select count(name),salary,dpt_id from employee group by salary,dpt_id having
		// salary>30000;

		CriteriaBuilder builder2 = session.getCriteriaBuilder();

		CriteriaQuery<Object[]> criteriaQuery2 = builder2.createQuery(Object[].class);
		Root<Employee> root = criteriaQuery2.from(Employee.class);
		criteriaQuery2.multiselect(builder2.count(root.get("name")), root.get("salary"), root.get("department"));
		criteriaQuery2.groupBy(root.get("salary"), root.get("department"));
		criteriaQuery2.having(builder2.greaterThan(root.get("salary"), 30000));

		Query<Object[]> query2 = session.createQuery(criteriaQuery2);
		List<Object[]> list2 = query2.getResultList();
		for (Object[] objects2 : list2) {
			long count = (Long) objects2[0];
			int salary = (Integer) objects2[1];
			Department department1 = (Department) objects2[2];
			System.out.println(
					"Number of Employee = " + count + "\t SALARY=" + salary + "\t DEPT NAME=" + department1.getName());
		}

		// select * from employee order by salary asc;

		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class);
		Root<Employee> roots = criteriaQuery.from(Employee.class);
		criteriaQuery.select(roots);
		//criteriaQuery.orderBy(builder.asc(roots.get("salary")));
		criteriaQuery.orderBy(builder.desc(roots.get("salary")));
		Query<Employee> query = session.createQuery(criteriaQuery);
		List<Employee> list = query.getResultList();
		for (Employee employee : list) {
			System.out.println("EMP NAME=" + employee.getName() + "\t SALARY=" + employee.getSalary());
		}

	}
}

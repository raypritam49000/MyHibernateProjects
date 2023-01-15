package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Contract_Employee;
import com.hibernate.model.Regular_Employee;
import com.hibernate.session.SessionProvider;

public class App {
	public static void main(String[] args) {
		System.out.println("Starting the Projects....");
		Session session = SessionProvider.getSession();
		System.out.println(session);

		Regular_Employee employee = new Regular_Employee();

		employee.setName("Pritam Ray");
		employee.setBonus(10000);
		employee.setSalary(50000);

		Contract_Employee contract_Employee = new Contract_Employee();
		contract_Employee.setContract_duration("3 years");
		contract_Employee.setName("Chandan Kumar");
		contract_Employee.setPay_per_hour(500);

		Transaction transaction = session.beginTransaction();
		session.save(employee);
		session.save(contract_Employee);
		
		transaction.commit();

		System.out.println("Ending the Projects....");
	}
}

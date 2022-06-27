package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hiberanate.model.AccountEntity;
import com.hiberanate.model.EmployeeEntity;
import com.hiberanate.session.SessionProvider;

public class App {

	public static void main(String[] args) {
		Session session = SessionProvider.getSession();
		System.out.println(session);

		EmployeeEntity emp = new EmployeeEntity();
		emp.setEmp_id(122);
		emp.setEmp_name("Pritam Ray");

		AccountEntity acc = new AccountEntity();
		acc.setAcc(844389833);
		acc.setName("Pritam Ray");

		acc.setEmployee(emp);
		emp.setAccount(acc);

		session.save(emp);
		session.save(acc);

		Transaction transaction = session.beginTransaction();
		transaction.commit();
		session.close();

	}

}

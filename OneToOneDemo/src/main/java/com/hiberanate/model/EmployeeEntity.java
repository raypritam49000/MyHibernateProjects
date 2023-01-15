package com.hiberanate.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employeeEntity")
public class EmployeeEntity {
	@Id
	private int emp_id;
	private String emp_name;

	@OneToOne
	@JoinColumn(name = "account_number")
	private AccountEntity account;

	public EmployeeEntity() {
		super();
	}

	public EmployeeEntity(int emp_id, String emp_name, AccountEntity account) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.account = account;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public AccountEntity getAccount() {
		return account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}

}

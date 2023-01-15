package com.hiberanate.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="accountEntity")
public class AccountEntity {
    @Id
	private int acc;
    
	private String name;
	
	@OneToOne(mappedBy="account")
	private EmployeeEntity employee;
	
	public AccountEntity() {
		super();
	}
	public AccountEntity(int acc, String name, EmployeeEntity employee) {
		super();
		this.acc = acc;
		this.name = name;
		this.employee = employee;
	}
	
	public int getAcc() {
		return acc;
	}
	public void setAcc(int acc) {
		this.acc = acc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public EmployeeEntity getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}
}

package com.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Customer {
	@Id
	private int c_id;
	private String c_name;

	@OneToOne
	private Address add;

	public Customer() {
		super();
	}

	public Customer(int c_id, String c_name, Address add) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.add = add;
	}

	public Address getAdd() {
		return add;
	}

	public void setAdd(Address add) {
		this.add = add;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

}

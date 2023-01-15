package com.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Address {
	@Id
	private int add_id;
	private String add_name;

	@OneToOne(mappedBy = "add")
	private Customer customer;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int add_id, String add_name, Customer customer) {
		super();
		this.add_id = add_id;
		this.add_name = add_name;
		this.customer = customer;
	}

	public int getAdd_id() {
		return add_id;
	}

	public void setAdd_id(int add_id) {
		this.add_id = add_id;
	}

	public String getAdd_name() {
		return add_name;
	}

	public void setAdd_name(String add_name) {
		this.add_name = add_name;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}

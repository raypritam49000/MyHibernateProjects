package com.hiberanate.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {
	@Id
	private int e_id;
	private String name;
	
	@OneToMany
	private List<Projects> list;

	public Employee() {
		super();
	}

	public Employee(int e_id, String name, List<Projects> list) {
		super();
		this.e_id = e_id;
		this.name = name;
		this.list = list;
	}

	public List<Projects> getList() {
		return list;
	}

	public void setList(List<Projects> list) {
		this.list = list;
	}

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

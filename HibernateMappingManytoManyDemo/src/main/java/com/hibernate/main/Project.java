package com.hibernate.main;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	private int p_id;
	private String p_name;
     
	@ManyToMany
	private List<Employee> employee;

	public Project() {
		super();
	}

	public Project(int p_id, String p_name, List<Employee> employee) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.employee = employee;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
}

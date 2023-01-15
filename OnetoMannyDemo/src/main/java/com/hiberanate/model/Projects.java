package com.hiberanate.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Projects")
public class Projects {
	@Id
	private int p_id;
	private String p_name;
	@ManyToOne
	private Employee employee;

	public Projects() {
		super();
	}

	public Projects(int p_id, String p_name, Employee employee) {
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}

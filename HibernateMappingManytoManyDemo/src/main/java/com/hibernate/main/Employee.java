package com.hibernate.main;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Employee {
	@Id
	private int e_id;
	private String e_name;

	@ManyToMany
	private List<Project> project;
	
	public Employee() {
		super();
	}

	public Employee(int e_id, String e_name, List<Project> project) {
		super();
		this.e_id = e_id;
		this.e_name = e_name;
		this.project = project;
	}

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

}

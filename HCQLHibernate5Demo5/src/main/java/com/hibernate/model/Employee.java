package com.hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMP_ID")
	private long id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "DESIGNATION")
	private String designation;

	@Column(name = "SALARY")
	private int salary;

	@ManyToOne
	@JoinColumn(name = "DPT_ID")
	private Department department;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, String designation, int salary) {
		super();
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
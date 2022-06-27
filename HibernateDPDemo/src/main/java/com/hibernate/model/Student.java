package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String addrsss;

	@Column(name = "age")
	private int age;
	
	public Student() 
	{
		
	}
	
	public int getId() {
		return id;
	}

	public Student(String name, String addrsss, int age) {
		super();
		this.name = name;
		this.addrsss = addrsss;
		this.age = age;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddrsss() {
		return addrsss;
	}

	public void setAddrsss(String addrsss) {
		this.addrsss = addrsss;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

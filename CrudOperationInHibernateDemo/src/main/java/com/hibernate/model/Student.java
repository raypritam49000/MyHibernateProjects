package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student 
{

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "id")
private long id;
private String name,email;


public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public Student(int id,String name,String email)
{
	this.id = id;
	this.name = name;
	this.email = email;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
@Column(name = "name")
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Column(name = "email")
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

}

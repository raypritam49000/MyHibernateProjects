package com.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Phone {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String number;
	private String phoneType;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="person_id")
	private Person person;

	public Phone() {
		super();
	}

	public Phone(String number, String phoneType) {
		super();
		this.number = number;
		this.phoneType = phoneType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}

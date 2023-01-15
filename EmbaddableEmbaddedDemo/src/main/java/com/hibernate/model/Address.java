package com.hibernate.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String student_city;
	private String student_state;
	private String student_country;

	public String getStudent_city() {
		return student_city;
	}

	public void setStudent_city(String student_city) {
		this.student_city = student_city;
	}

	public String getStudent_state() {
		return student_state;
	}

	public void setStudent_state(String student_state) {
		this.student_state = student_state;
	}

	public String getStudent_country() {
		return student_country;
	}

	public void setStudent_country(String student_country) {
		this.student_country = student_country;
	}

}

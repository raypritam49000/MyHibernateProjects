package com.hibernate.model;

import java.util.*;

public class Employee {
	private int id;
	private String name;
	private Map<String,String> mob;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<String,String> getMob() {
		return mob;
	}

	public void setMob(Map<String, String> mob) {
		this.mob = mob;
	}
}

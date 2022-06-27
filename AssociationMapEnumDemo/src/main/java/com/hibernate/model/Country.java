package com.hibernate.model;

import java.io.Serializable;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToMany;

@Entity
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)	
	@JoinColumn(name="country_id")
	@MapKeyEnumerated(EnumType.ORDINAL)
	private Map<Area,State> states;
	
	public Country(int id,String name,Map<Area,State> states){
		this.id=id;
		this.name=name;
		this.states=states;
	}
	public Country(){
	}
	public int getId() {
		return id;
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
	public Map<Area,State> getStates() {
		return states;
	}
	public void setStates(Map<Area,State> states) {
		this.states = states;
	}
}

package com.hibernate.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "state")
public class State  implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private int id;

	@Id
	@Column(name = "country_id")
	private int countryId;
	
	@Column(name = "area")
	private Area area;
		
	@Column(name = "name") 
	private String name;
	
	public State(int id,int countryId,Area area,String name){
		this.id=id;
		this.countryId=countryId;
		this.area=area;
		this.name= name;
	}
	public State(){}
	
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}


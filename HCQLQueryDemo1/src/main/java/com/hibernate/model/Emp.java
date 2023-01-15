package com.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Emp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int age;
    private double salary;
    private String street;
    private String city;
    private String state;
    private String country;

    @Override
    public String toString() {
        return "Emp{" + "id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", street=" + street + ", city=" + city + ", state=" + state + ", country=" + country + '}';
    }

    public Emp() {
        super();
    }
  
    public Emp(String name, int age, double salary, String street, String city, String state, String country) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
}

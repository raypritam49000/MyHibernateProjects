package com.hibernate.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int e_id;
   private String name;
   private String city;
   private double salary;
   private long mobile;

    public Employee() {
        super();
    }
   
    public Employee(String name, String city, double salary, long mobile) {
        this.name = name;
        this.city = city;
        this.salary = salary;
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Employee{" + "e_id=" + e_id + ", name=" + name + ", city=" + city + ", salary=" + salary + ", mobile=" + mobile + '}';
    }

    
    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }
}

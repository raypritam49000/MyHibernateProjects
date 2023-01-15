package com.hibernate.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student786")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String college;
    private int age;
    private String address;
    private double fees;
    
     @Override
    public String toString(){
     return "Id : "+this.getId()+"\nName : "+this.getName()+"\nAddress :  "+this.address+"\nAge : "+this.age+"\nFess: "+this.fees;
    }

    public Student() {
        super();
    }

    public Student(String name, String college, int age, String address, double fees) {
        this.name = name;
        this.college = college;
        this.age = age;
        this.address = address;
        this.fees = fees;
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

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }
    
  
}

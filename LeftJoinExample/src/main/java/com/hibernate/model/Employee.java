package com.hibernate.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int e_id;
    private String name;
    private int age;
    private long mobile;
    @OneToOne
    private Address address;

    @Override
    public String toString() {
        return this.e_id+" "+this.name+" "+this.age+" "+this.mobile+" "+address.getAdd_id()+" "+address.getCity()+" "+address.getCountry()+" "+address.getState();
    }
    
    public Employee() {
        super();
    }
    
    public Employee(String name, int age, long mobile) {
        this.name = name;
        this.age = age;
        this.mobile = mobile;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    
}

package com.hibernate.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employeeId")
    private int id;
    
    @Column(name="employeeName",nullable = false,length = 233)
    private String name;
    
    @Column(name="email")
    private String email;
    
    @Column(name ="date_of_joining")
    private Date doj;
    
    @Column(name="salary")
    private double salary;
    
    @Column(name="phone_no")
    private long phoneNo;
    
    @Column(name="phone_type")
    @Enumerated(EnumType.STRING)
    private PhoneType phoneType;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employee",fetch=FetchType.EAGER)
    private List<Address> addressList = new ArrayList<>();

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhone(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", email=" + email + ", doj=" + doj + ", salary=" + salary + ", phoneNo=" + phoneNo + ", phoneType=" + phoneType + ", addressList=" + addressList + '}';
    }
    
}

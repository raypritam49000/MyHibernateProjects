package com.hibernate.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId; 
    
    @Column(name="street_name")
    private String street;
    
    @Column(name="city_name")
    private String city;
    
    @Column(name="state_name")
    private String state;
    
    @Column(name="pincode")
    private int pincode;
    
    @Column(name="address_type")
    @Enumerated(EnumType.STRING)
    private AddressType addressType;
    
    @ManyToOne
    @JoinColumn(name="employeeId")
    private Employee employee;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
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

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    @Override
    public String toString() {
        return "Address{" + "addressId=" + addressId + ", street=" + street + ", city=" + city + ", state=" + state + ", pincode=" + pincode + ", addressType=" + addressType + ", employee=" + employee + '}';
    }
}

package com.hibernate.model;

import java.io.Serializable;

public class Customer implements Serializable {

    private int customerId;
    private String customerName;
    private String customerCity;

    public Customer() {
    }

    public Customer(String customerName, String customerCity) {
        this.customerName = customerName;
        this.customerCity = customerCity;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }
}

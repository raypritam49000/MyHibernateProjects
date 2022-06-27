package com.hibernate.model;

import java.util.Map;

public class Employee {

    private int id;
    private String name;
    private Map mobile;

    public Employee() {
        super();
    }

    public Employee(String name, Map mobile) {
        this.name = name;
        this.mobile = mobile;
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

    public Map getMobile() {
        return mobile;
    }

    public void setMobile(Map mobile) {
        this.mobile = mobile;
    }

}

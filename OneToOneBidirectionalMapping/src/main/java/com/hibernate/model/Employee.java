package com.hibernate.model;

import java.io.Serializable;

public class Employee implements Serializable 
{
    private static final long serialVersionUID = -889976693182180703L;
    
    private int id;
    private String name;
    private int age;
    private String dept;
    
    private Employee_Address employeeAddress;

    public Employee()
    {
        super();
    }

    public Employee(int id, String name, int age, String dept, Employee_Address employeeAddress)
    {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.dept = dept;
        this.employeeAddress = employeeAddress;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getDept()
    {
        return dept;
    }

    public void setDept(String dept)
    {
        this.dept = dept;
    }

    public Employee_Address getEmployeeAddress()
    {
        return employeeAddress;
    }

    public void setEmployeeAddress(Employee_Address employeeAddress)
    {
        this.employeeAddress = employeeAddress;
    }

    
}
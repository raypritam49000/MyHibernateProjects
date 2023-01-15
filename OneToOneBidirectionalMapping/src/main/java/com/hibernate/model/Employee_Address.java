package com.hibernate.model;

import java.io.Serializable;

public class Employee_Address implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private int Id;
    private String Street;
    private String City;
    private String State;
    private String Country;
    
    private Employee employee;

    public Employee_Address()
    {
        super();
    }

    public Employee_Address(int id, String street, String city, String state, String country, Employee employee)
    {
        super();
        Id = id;
        Street = street;
        City = city;
        State = state;
        Country = country;
        this.employee = employee;
    }

    public int getId()
    {
        return Id;
    }

    public void setId(int id)
    {
        Id = id;
    }

    public String getStreet()
    {
        return Street;
    }

    public void setStreet(String street)
    {
        Street = street;
    }

    public String getCity()
    {
        return City;
    }

    public void setCity(String city)
    {
        City = city;
    }

    public String getState()
    {
        return State;
    }

    public void setState(String state)
    {
        State = state;
    }

    public String getCountry()
    {
        return Country;
    }

    public void setCountry(String country)
    {
        Country = country;
    }

    public Employee getEmployee()
    {
        return employee;
    }

    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }
}
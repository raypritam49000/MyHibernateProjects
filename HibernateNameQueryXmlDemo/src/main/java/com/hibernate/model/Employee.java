package com.hibernate.model;


public class Employee {
    private int id;
    private String name;
    private int salary;
    private String job;

    public Employee() {
    }

    public Employee(String name, int salary, String job) {
        this.name = name;
        this.salary = salary;
        this.job = job;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + salary + " " + job;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

}

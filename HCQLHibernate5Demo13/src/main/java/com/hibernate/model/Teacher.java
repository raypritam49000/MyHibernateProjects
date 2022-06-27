package com.hibernate.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "tecaher_table")
@DynamicUpdate
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teacher_id")
    private int id;
    @Column(name = "teacher_name", nullable = false, length = 100)
    private String name;
    @Column(name = "teacher_city", nullable = false, length = 100)
    private String city;
    @Column(name = "teacher_email", unique = true)
    private String email;
    @Column(name = "teacher_age", nullable = false, length = 100)
    private int age;
    @Column(name = "teacher_state", nullable = false, length = 100)
    private String state;

    public Teacher() {
    }

    public Teacher(String name, String city, String email, int age, String state) {
        this.name = name;
        this.city = city;
        this.email = email;
        this.age = age;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Teacher{" + "id=" + id + ", name=" + name + ", city=" + city + ", email=" + email + ", age=" + age + ", state=" + state + '}';
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

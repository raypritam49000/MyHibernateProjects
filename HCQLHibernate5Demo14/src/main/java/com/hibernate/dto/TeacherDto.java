package com.hibernate.dto;

public class TeacherDto {
   private String name;
   private String email;
   private String city;

    public TeacherDto(String name, String email, String city) {
        this.name = name;
        this.email = email;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

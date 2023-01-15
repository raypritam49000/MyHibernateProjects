package com.hibernate.model;

import java.util.*;

public class Emp {

    private String name;
    private int id;
    private List mob;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List getMob() {
        return mob;
    }

    public void setMob(List mob) {
        this.mob = mob;
    }
}

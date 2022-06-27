package com.hibernate.model;

import java.util.Set;

public class Employee {
    private int eid;
    private String ename;
    private Set mobile;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Set getMobile() {
        return mobile;
    }

    public void setMobile(Set mobile) {
        this.mobile = mobile;
    }
}

package com.hibernate.model;

import java.util.Date;

public class Passport {
private int passportNumber;
private Date issudDate;
private Date expireDate;
private Person person;

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Date getIssudDate() {
        return issudDate;
    }

    public void setIssudDate(Date issudDate) {
        this.issudDate = issudDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


}

package com.hibernate.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Owner owner;

    @Column(name = "wheelDrive")
    @Enumerated(EnumType.STRING)
    private WheelDrive wheelDrive;
    
    public Car() {
    }

    public Car(long id, Owner owner, WheelDrive wheelDrive) {
        this.id = id;
        this.owner = owner;
        this.wheelDrive = wheelDrive;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public WheelDrive getWheelDrive() {
        return wheelDrive;
    }

    public void setWheelDrive(WheelDrive wheelDrive) {
        this.wheelDrive = wheelDrive;
    }
    
    

}
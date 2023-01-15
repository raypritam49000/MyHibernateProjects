package com.hibernate.model;

import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ownerId")
    private long id;
    
    @Column(name="ownerName")
    private String name;

    @OneToMany(mappedBy="owner")
    @MapKeyEnumerated(EnumType.STRING)
    private Map<WheelDrive, Car> carMap;

    public Owner() {
    }

    public Owner(String name, Map<WheelDrive, Car> carMap) {
        this.name = name;
        this.carMap = carMap;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Map<WheelDrive, Car> getCarMap() {
        return carMap;
    }

    public void setCarMap(Map<WheelDrive, Car> carMap) {
        this.carMap = carMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
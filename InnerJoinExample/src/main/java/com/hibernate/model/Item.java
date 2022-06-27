package com.hibernate.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item implements Serializable {
    @Id
    @Column(name="iid")
    private int itemId;
    @Column(name="iname")
    private String itemName;
    @Column(name="price")
    private int price;

    public Item() {
        super();
    }

    public Item(int itemId, String itemName, int price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
    }

    
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}


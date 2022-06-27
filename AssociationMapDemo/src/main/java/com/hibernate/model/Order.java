package com.hibernate.model;

import java.io.Serializable;
import java.util.Map;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @ElementCollection
    @CollectionTable(name = "order_item_mapping", 
    joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "item_name")
    @Column(name = "price")
    private Map<String, Double> itemPriceMap;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Double> getItemPriceMap() {
        return itemPriceMap;
    }

    public void setItemPriceMap(Map<String, Double> itemPriceMap) {
        this.itemPriceMap = itemPriceMap;
    }

    
}
package com.hibernate.model;

import java.io.Serializable;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
   
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "order_item_mapping", 
    joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "item_id", referencedColumnName = "id")})
    @MapKey(name = "itemName")
    private Map<String, Item> itemMap;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Item> getItemMap() {
        return itemMap;
    }

    public void setItemMap(Map<String, Item> itemMap) {
        this.itemMap = itemMap;
    }   
}
    
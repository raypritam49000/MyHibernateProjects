package com.hibernate.model;

public class Item {

    private int itemId;
    private String itemName;
    private int price;
    private Customer customer;

    public Item() {
        super();
    }

    public Item(int itemId, String itemName, int price, Customer customer) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.customer = customer;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}

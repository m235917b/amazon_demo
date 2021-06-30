package com.dm.amazon_demo.jsonclasses;

@SuppressWarnings("unused")
public class OrderWithIds {

    private int id;

    private String orderDate;

    private int customer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

}

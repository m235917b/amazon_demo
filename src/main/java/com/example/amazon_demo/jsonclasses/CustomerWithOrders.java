package com.example.amazon_demo.jsonclasses;

import com.example.amazon_demo.entities.Customer;

import java.util.List;

public class CustomerWithOrders {
    private Customer customer;

    private List<OrderWithOrderPositions> ordersWithOrderPositions;

    public CustomerWithOrders() {

    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderWithOrderPositions> getOrdersWithOrderPositions() {
        return ordersWithOrderPositions;
    }

    public void setOrdersWithOrderPositions(List<OrderWithOrderPositions> ordersWithOrderPositions) {
        this.ordersWithOrderPositions = ordersWithOrderPositions;
    }
}

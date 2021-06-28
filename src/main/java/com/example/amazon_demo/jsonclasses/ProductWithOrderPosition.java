package com.example.amazon_demo.jsonclasses;

import com.example.amazon_demo.entities.OrderPosition;
import com.example.amazon_demo.entities.Product;

import java.util.List;

public class ProductWithOrderPosition {
    private Product product;

    private List<OrderPosition> orderPositions;

    public ProductWithOrderPosition() {

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<OrderPosition> getOrderPositions() {
        return orderPositions;
    }

    public void setOrderPositions(List<OrderPosition> orderPositions) {
        this.orderPositions = orderPositions;
    }
}

package com.dm.amazon_demo.jsonclasses;

import com.dm.amazon_demo.entities.Order;
import com.dm.amazon_demo.entities.OrderPosition;

import java.util.List;

@SuppressWarnings("unused")
public class OrderWithOrderPositions {
    private Order order;

    private List<OrderPosition> orderPositions;

    public OrderWithOrderPositions() {

    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderPosition> getOrderPositions() {
        return orderPositions;
    }

    public void setOrderPositions(List<OrderPosition> orderPositions) {
        this.orderPositions = orderPositions;
    }
}

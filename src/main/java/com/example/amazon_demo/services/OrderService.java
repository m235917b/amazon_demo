package com.example.amazon_demo.services;

import com.example.amazon_demo.entities.Customer;
import com.example.amazon_demo.entities.Order;
import com.example.amazon_demo.jsonclasses.OrderWithOrderPositions;
import com.example.amazon_demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderPositionService orderPositionService;

    @Transactional
    public List<OrderWithOrderPositions> findByCustomer(Customer customer) {
        final List<Order> orders = orderRepository.findByCustomer(customer);
        final List<OrderWithOrderPositions> ordersWithOrderPositions = new ArrayList<OrderWithOrderPositions>();

        for (Order order : orders) {
            final OrderWithOrderPositions orderWithOrderPositions = new OrderWithOrderPositions();

            orderWithOrderPositions.setOrder(order);
            orderWithOrderPositions.setOrderPositions(orderPositionService.findByOrder(order));

            ordersWithOrderPositions.add(orderWithOrderPositions);
        }

        return ordersWithOrderPositions;
    }
}

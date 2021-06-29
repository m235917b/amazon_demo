package com.dm.amazon_demo.services;

import com.dm.amazon_demo.jsonclasses.OrderWithOrderPositions;
import com.dm.amazon_demo.entities.Order;
import com.dm.amazon_demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@SuppressWarnings("unused")
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderPositionService orderPositionService;

    @Autowired
    private CustomerService customerService;

    private List<OrderWithOrderPositions> getOrdersWithPositions(List<Order> orders) {
        return orders
                .stream()
                .map(o -> new OrderWithOrderPositions(o, orderPositionService.findByOrder(o)))
                .toList();
    }

    @Transactional
    public List<OrderWithOrderPositions> findByCustomer(String name) {
        return getOrdersWithPositions(
                orderRepository.findByCustomer(
                        customerService.getCustomerByName(name).orElseThrow(
                                () -> new ResponseStatusException(
                                        HttpStatus.NOT_FOUND, "No customer with this name found!"))));
    }

    @Transactional
    public List<OrderWithOrderPositions> getOrders() {
        return getOrdersWithPositions(orderRepository.findAll());
    }
}

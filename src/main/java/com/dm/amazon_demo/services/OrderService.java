package com.dm.amazon_demo.services;

import com.dm.amazon_demo.jsonclasses.OrderWithOrderPositions;
import com.dm.amazon_demo.entities.Order;
import com.dm.amazon_demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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
                .map(o -> new OrderWithOrderPositions(o, orderPositionService.find(o)))
                .toList();
    }

    @Transactional
    public List<OrderWithOrderPositions> findByCustomer(String name) {
        return getOrdersWithPositions(orderRepository.findByCustomerName(name));
    }

    @Transactional
    public List<OrderWithOrderPositions> get() {
        return getOrdersWithPositions(orderRepository.findAll());
    }

    public int addOrder(Order order) {
        return orderRepository.save(order).getId();
    }

    public void put(Order order) {
        orderRepository.save(order);
    }

    public void patch(int id, Map<String, String> values) {
    }

    @Transactional
    public void delete(int id) {
        orderRepository.deleteById(id);
    }
}

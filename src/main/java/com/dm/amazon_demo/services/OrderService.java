package com.dm.amazon_demo.services;

import com.dm.amazon_demo.jsonclasses.OrderWithOrderPositions;
import com.dm.amazon_demo.entities.Customer;
import com.dm.amazon_demo.entities.Order;
import com.dm.amazon_demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@SuppressWarnings("unused")
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderPositionService orderPositionService;

    @Autowired
    private CustomerService customerService;

    @Transactional
    public List<OrderWithOrderPositions> findByCustomer(String name) {
        final Optional<Customer> customers = customerService.getCustomerByName(name);

        if (customers.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No customer with this name found!");
        }

        final Customer customer = customers.get();

        final List<Order> orders = orderRepository.findByCustomer(customer);
        final List<OrderWithOrderPositions> ordersWithOrderPositions = new ArrayList<>();

        for (Order order : orders) {
            final OrderWithOrderPositions orderWithOrderPositions = new OrderWithOrderPositions();

            orderWithOrderPositions.setOrder(order);
            orderWithOrderPositions.setOrderPositions(orderPositionService.findByOrder(order));

            ordersWithOrderPositions.add(orderWithOrderPositions);
        }

        return ordersWithOrderPositions;
    }
}

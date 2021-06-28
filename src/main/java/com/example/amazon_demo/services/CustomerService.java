package com.example.amazon_demo.services;

import com.example.amazon_demo.entities.Customer;
import com.example.amazon_demo.jsonclasses.CustomerWithOrders;
import com.example.amazon_demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderService orderService;

    @Transactional
    public List<CustomerWithOrders> getCustomers() {
        final List<Customer> customers = customerRepository.findAll();
        final List<CustomerWithOrders> customersWithOrders = new ArrayList<>();

        for (Customer customer : customers) {
            final CustomerWithOrders customerWithOrders = new CustomerWithOrders();

            customerWithOrders.setCustomer(customer);
            customerWithOrders.setOrdersWithOrderPositions(orderService.findByCustomer(customer));

            customersWithOrders.add(customerWithOrders);
        }

        return customersWithOrders;
    }
}

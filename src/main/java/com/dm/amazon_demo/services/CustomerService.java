package com.dm.amazon_demo.services;

import com.dm.amazon_demo.entities.Customer;
import com.dm.amazon_demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@SuppressWarnings("unused")
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderService orderService;

    @Transactional
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Transactional
    public Optional<Customer> getCustomerByName(String name) {
        return customerRepository
                .findOne(Example
                        .of(new Customer(name), ExampleMatcher
                                .matchingAll()
                                .withIgnorePaths("id")));
    }
}

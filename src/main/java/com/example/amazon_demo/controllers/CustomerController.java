package com.example.amazon_demo.controllers;

import com.example.amazon_demo.entities.Customer;
import com.example.amazon_demo.jsonclasses.CustomerWithOrders;
import com.example.amazon_demo.repositories.CustomerRepository;
import com.example.amazon_demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/customers")
    @Transactional
    public List<CustomerWithOrders> getCustomers() {
        return customerService.getCustomers();
    }
}

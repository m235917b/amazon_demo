package com.example.amazon_demo.controllers;

import com.example.amazon_demo.entities.Customer;
import com.example.amazon_demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}

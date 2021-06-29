package com.dm.amazon_demo.controllers;

import com.dm.amazon_demo.services.CustomerService;
import com.dm.amazon_demo.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@SuppressWarnings("unused")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/customers")
    @Transactional
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }
}

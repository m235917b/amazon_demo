package com.dm.amazon_demo.controllers;

import com.dm.amazon_demo.services.CustomerService;
import com.dm.amazon_demo.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/register")
    public void registerNewCustomer(@RequestBody Customer customer) {
        customerService.registerNewCustomer(customer);
    }

    @DeleteMapping(value = "/deleteCustomer")
    public void deleteCustomer(@RequestBody String name) {
        customerService.deleteCustomer(name);
    }


}

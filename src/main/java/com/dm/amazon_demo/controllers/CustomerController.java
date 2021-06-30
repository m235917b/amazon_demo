package com.dm.amazon_demo.controllers;

import com.dm.amazon_demo.services.CustomerService;
import com.dm.amazon_demo.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@SuppressWarnings("unused")
@RequestMapping(value = "/customer")
@Transactional
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/all")
    public List<Customer> get() {
        return customerService.get();
    }

    @PostMapping(value = "/register")
    public int registerNewCustomer(@RequestBody Customer customer) {
        return customerService.registerNewCustomer(customer);
    }

    @PutMapping(value = "")
    public void put(@RequestBody Customer customer) {
        customerService.put(customer);
    }

    @PatchMapping(value = "/{id}")
    public void patch(@PathVariable int id, @RequestBody Map<String, String> values) {
        customerService.patch(id, values);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        customerService.delete(id);
    }
}

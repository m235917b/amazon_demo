package com.dm.amazon_demo.services;

import com.dm.amazon_demo.entities.Customer;
import com.dm.amazon_demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@SuppressWarnings("unused")
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public List<Customer> get() {
        return customerRepository.findAll();
    }

    public Customer findById(int id) {
        return customerRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Customer doesn't exist!"));
    }

    @Transactional
    public Optional<Customer> getCustomerByName(String name) {
        return customerRepository
                .findOne(Example
                        .of(new Customer(name), ExampleMatcher
                                .matchingAll()
                                .withIgnorePaths("id")));
    }

    @Transactional
    public int registerNewCustomer(Customer customer) {
        if (customerRepository.exists(Example.of(customer,
                ExampleMatcher.matchingAll().withIgnorePaths("id")))) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Benutzer mit diesem Namen existiert bereits!");
        }

        return customerRepository.save(customer).getId();
    }

    @Transactional
    public void put(Customer customer) {
        customerRepository.save(customer);
    }

    @Transactional
    public void patch(int id, Map<String, String> values) {
        final Customer customer = customerRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Customer doesn't exist!"));
        values.forEach(customer::setByName);
        customerRepository.save(customer);
    }

    @Transactional
    public void delete(int id) {
        customerRepository.deleteById(id);
    }
}

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
import java.util.Optional;

@Service
@SuppressWarnings("unused")
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

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
    @Transactional
    public void registerNewCustomer(Customer customer) {

        if (customerRepository.findByName(customer.getName()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Benutzer mit diesem Namen existiert bereits!");
        }

        customerRepository.save(customer);

    }

    @Transactional
    public void deleteCustomer(String name) {

       customerRepository.delete(getCustomerByName(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Benutzer mit diesem Namen konnte nicht gefunden werden!")));



    }


}

package com.dm.amazon_demo.controllers;

import com.dm.amazon_demo.entities.Product;
import com.dm.amazon_demo.repositories.CustomerRepository;
import com.dm.amazon_demo.repositories.ProductRepository;
import com.dm.amazon_demo.services.CustomerService;
import com.dm.amazon_demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SuppressWarnings("unused")

public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products")
    @Transactional
    public List<Product> getProducts() {

        return productRepository.findAll();
    }

}

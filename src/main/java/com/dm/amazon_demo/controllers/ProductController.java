package com.dm.amazon_demo.controllers;

import com.dm.amazon_demo.entities.Customer;
import com.dm.amazon_demo.entities.Product;
import com.dm.amazon_demo.repositories.ProductRepository;
import com.dm.amazon_demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@SuppressWarnings("unused")
@RequestMapping(value = "/product")
@Transactional
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/all")
    public List<Product> get() {
        return productRepository.findAll();
    }

    @PostMapping(value = "/register")
    public int registerNewProduct(@RequestBody Product product) {
        return productService.registerNewProduct(product);
    }

    @PutMapping(value = "")
    public void put(@RequestBody Product product) {
        productService.put(product);
    }

    @PatchMapping(value = "/{id}")
    public void patch(@PathVariable int id, @RequestBody Map<String, String> values) {
        productService.patch(id, values);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        productService.delete(id);
    }
}

package com.dm.amazon_demo.services;

import com.dm.amazon_demo.entities.Customer;
import com.dm.amazon_demo.entities.Product;
import com.dm.amazon_demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@SuppressWarnings("unused")
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public List<Product> getProducts() {

        return productRepository.findAll();
    }

    @Transactional
    public Optional<Product> getProductById(int id) {
        final Product product = new Product();
        product.setId(id);

        return productRepository.findOne(Example.of(product, ExampleMatcher.matchingAll()));

    }
}

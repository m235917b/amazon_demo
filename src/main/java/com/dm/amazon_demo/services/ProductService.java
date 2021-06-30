package com.dm.amazon_demo.services;

import com.dm.amazon_demo.entities.Product;
import com.dm.amazon_demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Product> get() {
        return productRepository.findAll();
    }

    @Transactional
    public Optional<Product> get(int id) {
        return productRepository.findById(id);
    }

    @Transactional
    public void delete(int id) {
        productRepository.deleteById(id);
    }
}

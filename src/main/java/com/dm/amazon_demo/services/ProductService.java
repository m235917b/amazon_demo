package com.dm.amazon_demo.services;

import com.dm.amazon_demo.entities.Customer;
import com.dm.amazon_demo.entities.Product;
import com.dm.amazon_demo.repositories.ProductRepository;
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
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public List<Product> get() {
        return productRepository.findAll();
    }
    @Transactional
    public Product findById(int id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Customer doesn't exist!"));
    }

    @Transactional
    public Optional<Product> get(int id) {
        return productRepository.findById(id);
    }

    @Transactional
    public int registerNewProduct(Product product) {
        if (productRepository.exists(Example.of(product,
                ExampleMatcher.matchingAll().withIgnorePaths("id")))) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Benutzer mit diesem Namen existiert bereits!");
        }

        return productRepository.save(product).getId();
    }

    @Transactional
    public void put(Product product) {
        productRepository.save(product);
    }

    @Transactional
    public void patch(int id, Map<String, String> values) {
        final Product product = productRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Product doesn't exist!"));
        values.forEach(product::setByName);
        productRepository.save(product);
    }

    @Transactional
    public void delete(int id) {
        productRepository.deleteById(id);
    }
}

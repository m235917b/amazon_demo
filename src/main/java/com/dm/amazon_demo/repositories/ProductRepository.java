package com.dm.amazon_demo.repositories;

import com.dm.amazon_demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unused")
public interface ProductRepository extends JpaRepository<Product, Integer> {

}

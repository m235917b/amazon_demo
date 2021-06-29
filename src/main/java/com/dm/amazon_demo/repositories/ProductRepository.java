package com.dm.amazon_demo.repositories;

import com.dm.amazon_demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings("unused")
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select p from Product p where p.id = ?1")
    List<Product> getAllBy(int id);


}

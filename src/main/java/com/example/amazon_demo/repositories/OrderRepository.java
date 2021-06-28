package com.example.amazon_demo.repositories;

import com.example.amazon_demo.entities.Customer;
import com.example.amazon_demo.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("select o from Order o where o.customer = ?1")
    List<Order> findByCustomer(Customer customer);
}

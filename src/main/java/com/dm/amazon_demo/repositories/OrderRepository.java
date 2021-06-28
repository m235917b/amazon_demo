package com.dm.amazon_demo.repositories;

import com.dm.amazon_demo.entities.Customer;
import com.dm.amazon_demo.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings("unused")
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("select o from Order o where o.customer = ?1")
    List<Order> findByCustomer(Customer customer);
}

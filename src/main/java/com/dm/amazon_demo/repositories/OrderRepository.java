package com.dm.amazon_demo.repositories;

import com.dm.amazon_demo.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unused")
public interface OrderRepository extends JpaRepository<Order, Integer> {

}

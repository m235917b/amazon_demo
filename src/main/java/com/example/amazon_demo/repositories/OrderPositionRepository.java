package com.example.amazon_demo.repositories;

import com.example.amazon_demo.entities.Order;
import com.example.amazon_demo.entities.OrderPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderPositionRepository extends JpaRepository<OrderPosition, Integer> {
    @Query("select op from OrderPosition op where op.order = ?1")
    List<OrderPosition> findByOrder(Order order);
}

package com.dm.amazon_demo.repositories;

import com.dm.amazon_demo.entities.Order;
import com.dm.amazon_demo.entities.OrderPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings("unused")
public interface OrderPositionRepository extends JpaRepository<OrderPosition, Integer> {
    List<OrderPosition> findByOrder(Order order);
}

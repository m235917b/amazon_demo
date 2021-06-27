package com.example.amazon_demo.repositories;

import com.example.amazon_demo.entities.OrderPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderPositionRepository extends JpaRepository<OrderPosition, Integer> {

}

package com.example.amazon_demo.services;

import com.example.amazon_demo.entities.Order;
import com.example.amazon_demo.entities.OrderPosition;
import com.example.amazon_demo.repositories.OrderPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderPositionService {
    @Autowired
    private OrderPositionRepository orderPositionRepository;

    @Transactional
    public List<OrderPosition> findByOrder(Order order) {
        return orderPositionRepository.findByOrder(order);
    }
}

package com.dm.amazon_demo.services;

import com.dm.amazon_demo.entities.Order;
import com.dm.amazon_demo.entities.OrderPosition;
import com.dm.amazon_demo.repositories.OrderPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@SuppressWarnings("unused")
public class OrderPositionService {
    @Autowired
    private OrderPositionRepository orderPositionRepository;

    @Transactional
    public List<OrderPosition> findByOrder(Order order) {
        return orderPositionRepository.findByOrder(order);
    }
}

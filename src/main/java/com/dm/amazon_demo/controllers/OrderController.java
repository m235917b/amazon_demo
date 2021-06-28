package com.dm.amazon_demo.controllers;

import com.dm.amazon_demo.jsonclasses.OrderWithOrderPositions;
import com.dm.amazon_demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@SuppressWarnings("unused")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/order")
    @Transactional
    public List<OrderWithOrderPositions> getOrders(@RequestHeader("name") String name) {
        return orderService.findByCustomer(name);
    }
}

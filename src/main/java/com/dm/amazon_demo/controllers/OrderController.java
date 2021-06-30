package com.dm.amazon_demo.controllers;

import com.dm.amazon_demo.entities.Customer;
import com.dm.amazon_demo.entities.Order;
import com.dm.amazon_demo.jsonclasses.OrderWithOrderPositions;
import com.dm.amazon_demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@SuppressWarnings("unused")
@RequestMapping("/order")
@Transactional
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/fromCustomer")
    public List<OrderWithOrderPositions> getByCustomer(@RequestHeader("name") String name) {
        return orderService.findByCustomer(name);
    }

    @GetMapping(value = "/all")
    public List<OrderWithOrderPositions> get() {
        return orderService.get();
    }

    @PostMapping(value = "/add")
    public int addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @PutMapping(value = "")
    public void put(@RequestBody Order order) {
        orderService.put(order);
    }

    @PatchMapping(value = "/{id}")
    public void patch(@PathVariable int id, @RequestBody Map<String, String> values) {
        orderService.patch(id, values);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        orderService.delete(id);
    }
}

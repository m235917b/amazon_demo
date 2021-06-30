package com.dm.amazon_demo.controllers;

import com.dm.amazon_demo.entities.Order;
import com.dm.amazon_demo.jsonclasses.OrderPositionWithIds;
import com.dm.amazon_demo.jsonclasses.OrderWithIds;
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
    public int addOrder(@RequestBody OrderWithIds orderWithIds) {
        return orderService.addOrder(orderWithIds);
    }

    @PostMapping(value = "/position")
    public void addOrderPosition(@RequestBody OrderPositionWithIds orderPositionWithIds) {
        orderService.savePosition(orderService.fromOrderPositionWithIds(orderPositionWithIds));
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

    @DeleteMapping(value = "/{id}/position/{posId}")
    public void delete(@PathVariable int id, @PathVariable int posId) {
        orderService.deletePosition(id, posId);
    }

}

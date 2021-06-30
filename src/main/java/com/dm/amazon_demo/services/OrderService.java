package com.dm.amazon_demo.services;

import com.dm.amazon_demo.entities.OrderPosition;
import com.dm.amazon_demo.jsonclasses.OrderPositionWithIds;
import com.dm.amazon_demo.jsonclasses.OrderWithOrderPositions;
import com.dm.amazon_demo.entities.Order;
import com.dm.amazon_demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@Service
@SuppressWarnings("unused")
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderPositionService orderPositionService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    private List<OrderWithOrderPositions> getOrdersWithPositions(List<Order> orders) {
        return orders
                .stream()
                .map(o -> new OrderWithOrderPositions(o, orderPositionService.find(o)))
                .toList();
    }

    @Transactional
    public Order findById(int id) {
        return orderRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Order doesn't exist!"));
    }

    @Transactional
    public List<OrderWithOrderPositions> findByCustomer(String name) {
        return getOrdersWithPositions(orderRepository.findByCustomerName(name));
    }

    @Transactional
    public List<OrderWithOrderPositions> get() {
        return getOrdersWithPositions(orderRepository.findAll());
    }

    @Transactional
    public int addOrder(Order order) {
        return orderRepository.save(order).getId();
    }

    @Transactional
    public void put(Order order) {
        orderRepository.save(order);
    }

    @Transactional
    public void savePosition(OrderPosition orderPosition) {
        orderPositionService.save(orderPosition);
    }

    @Transactional
    public void patch(int id, Map<String, String> values) {
        final Order order = orderRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Order doesn't exist!"));

        values.forEach(order::setByName);

        orderRepository.save(order);
    }

    @Transactional
    public void delete(int id) {
        orderRepository.deleteById(id);
    }

    @Transactional
    public void deletePosition(int id, int posId) {
        orderPositionService.deleteById(posId);
    }

    public OrderPosition fromOrderPositionWithIds(OrderPositionWithIds orderPositionWithIds) {
        final OrderPosition orderPosition = new OrderPosition();

        orderPosition.setId(orderPositionWithIds.getId());
        orderPosition.setQuantity(orderPositionWithIds.getQuantity());
        orderPosition.setBuyingprice(orderPositionWithIds.getBuyingprice());
        orderPosition.setOrder(findById(orderPositionWithIds.getOrder()));
        orderPosition.setProduct(productService
                .get(orderPositionWithIds.getProduct())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Product doesn't exist!")));

        return orderPosition;
    }

}

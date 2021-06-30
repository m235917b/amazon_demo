package com.dm.amazon_demo.entities;

import com.dm.amazon_demo.services.CustomerService;
import com.dm.amazon_demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "`order`")
@SuppressWarnings("unused")
public class Order extends ReflectionMapper {
    @Autowired
    private CustomerService customerService;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "orderdate")
    private LocalDateTime orderDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private List<OrderPosition> orderPositions;

    public Order() {

    }

    @Override
    protected void initReflectionMapper() {
        reflectionMap.put("id", i -> setId(Integer.parseInt(i)));
        reflectionMap.put("orderDate", d -> setOrderDate(LocalDateTime.parse(d)));
        reflectionMap.put("customer", c -> setCustomer(customerService.findById(Integer.parseInt(c))));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderPosition> getOrderPositions() {
        return orderPositions;
    }

    public void setOrderPositions(List<OrderPosition> orderPositions) {
        this.orderPositions = orderPositions;
    }
}

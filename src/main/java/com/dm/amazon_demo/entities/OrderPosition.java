package com.dm.amazon_demo.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "orderposition")
@SuppressWarnings("unused")
public class OrderPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "buyingprice")
    private int buyingprice;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product product;

    public OrderPosition() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getBuyingprice() {
        return buyingprice;
    }

    public void setBuyingprice(int buyingprice) {
        this.buyingprice = buyingprice;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}

package com.dm.amazon_demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@SuppressWarnings("unused")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public Customer() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

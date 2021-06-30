package com.dm.amazon_demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@SuppressWarnings("unused")
public class Customer extends ReflectionMapper {

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

    @Override
    protected void initReflectionMapper() {
        reflectionMap.put("id", i -> setId(Integer.parseInt(i)));
        reflectionMap.put("name", this::setName);
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

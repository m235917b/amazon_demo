package com.dm.amazon_demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "product")
@SuppressWarnings("unused")
public class Product extends ReflectionMapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;

    public Product() {

    }

    @Override
    protected void initReflectionMapper() {
        reflectionMap.put("id", i -> setId(Integer.parseInt(i)));
        reflectionMap.put("title", this::setTitle);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}

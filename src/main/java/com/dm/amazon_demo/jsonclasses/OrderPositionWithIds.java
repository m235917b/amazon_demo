package com.dm.amazon_demo.jsonclasses;

@SuppressWarnings("unused")
public class OrderPositionWithIds {

    private int id;

    private int quantity;

    private int buyingprice;

    private int order;

    private int product;

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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

}

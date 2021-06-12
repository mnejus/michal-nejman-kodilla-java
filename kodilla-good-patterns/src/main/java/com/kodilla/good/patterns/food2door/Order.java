package com.kodilla.good.patterns.food2door;

public class Order {
    private User user;
    private Supplier supplier;
    private Product product;
    private String numOrder;

    public Order(User user, Supplier supplier, Product product, String numOrder) {
        this.user = user;
        this.supplier = supplier;
        this.product = product;
        this.numOrder = numOrder;
    }

    public User getUser() {
        return user;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public Product getProduct() {
        return product;
    }

    public String getNumOrder() {
        return numOrder;
    }
}

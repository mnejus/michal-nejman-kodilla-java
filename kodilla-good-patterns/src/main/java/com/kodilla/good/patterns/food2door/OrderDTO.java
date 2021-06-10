package com.kodilla.good.patterns.food2door;

public class OrderDTO {
    public Product product;

    public OrderDTO(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
}

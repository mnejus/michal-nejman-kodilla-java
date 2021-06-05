package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class OrderRequest {
    public User user;
    public Product product;
    public LocalDateTime dateOrder;

    public OrderRequest(final User user, final Product product, final LocalDateTime dateOrder) {
        this.user = user;
        this.product = product;
        this.dateOrder = dateOrder;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public LocalDateTime getDateOrder() {
        return dateOrder;
    }
}

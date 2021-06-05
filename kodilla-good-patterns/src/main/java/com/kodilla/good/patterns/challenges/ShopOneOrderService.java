package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class ShopOneOrderService implements OrderService {
    @Override
    public boolean order(User user, Product product, LocalDateTime dateOrder) {
        return false;
    }
}

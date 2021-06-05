package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        User user = new User("Michał Nejman", "nejman.michal@poczta.poczta");
        Product product = new Product("Elektronika", "Kabel HDMI - DisplayPort", 16.89, true);
        LocalDateTime dateOrder = LocalDateTime.of(2021, 6, 5, 12, 50);

        return new OrderRequest(user, product, dateOrder);
    }
}

package com.kodilla.good.patterns.food2door;

import static com.kodilla.good.patterns.food2door.Suppliers.*;

public class Application {

    public static void main(String[] args) {
        OrderDTO orderDTO = new OrderDTO(new Product("fruit", "lemon", 10));
        OrderProcessor orderProcessor = new OrderProcessor();

        if (!orderProcessor.ordered(orderDTO.product)) {
            orderProcessor.process(EXTRA_FOOD_SHOP, orderDTO);
        } else {
            System.out.println("empty ...");
        }
    }
}

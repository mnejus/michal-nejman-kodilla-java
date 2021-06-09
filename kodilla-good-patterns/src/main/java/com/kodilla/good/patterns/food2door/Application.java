package com.kodilla.good.patterns.food2door;

public class Application {

    public static void main(String[] args) {

        OrderRetriever orderRetriever = new OrderRetriever();
        Order orderEFS = orderRetriever.retrieve1();
        Order orderGFS = orderRetriever.retrieve2();
        Order orderHF = orderRetriever.retrieve3();

        OrderProcessor orderProcessor1 = new OrderProcessor(new ExtraFoodShop(), orderEFS);
        OrderProcessor orderProcessor2 = new OrderProcessor(new GlutenFreeShop(), orderGFS);
        OrderProcessor orderProcessor3 = new OrderProcessor(new HealthyShop(), orderHF);

        orderProcessor1.process();
        orderProcessor2.process();
        orderProcessor3.process();
    }
}

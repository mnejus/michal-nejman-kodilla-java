package com.kodilla.good.patterns.food2door;

public class OrderProcessor {
    private final OrderService orderService;
    private final Order order;

    public OrderProcessor(OrderService orderService, Order order) {
        this.orderService = orderService;
        this.order = order;

    }

    public boolean process() {
        boolean isOrdered = orderService.process(order.getProduct());

        if (isOrdered) {
            System.out.println("Thank you! Your order number is: " + order.getNumOrder());
            System.out.println();
        } else {
            System.out.println("Unfinished order!");
            System.out.println();
        }

        return isOrdered;
    }
}

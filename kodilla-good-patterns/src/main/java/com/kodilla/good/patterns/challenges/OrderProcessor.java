package com.kodilla.good.patterns.challenges;

public class OrderProcessor {
    private final OrderService orderService;
    private final ConfirmService confirmService;
    private final OrderRepository orderRepository;

    public OrderProcessor(OrderService orderService, ConfirmService confirmService, OrderRepository orderRepository) {
        this.orderService = orderService;
        this.confirmService = confirmService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isOrdered = orderService.order(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getDateOrder());

        if (isOrdered) {
            confirmService.confirm(orderRequest.getUser());
            orderRepository.createOrder(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getDateOrder());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}

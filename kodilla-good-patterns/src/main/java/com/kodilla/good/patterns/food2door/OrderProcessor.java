package com.kodilla.good.patterns.food2door;

public class OrderProcessor implements OrderService {
    private Supplier supplier;
    private Product product;

    public OrderDTO process(String shopName, OrderDTO orderDTO) {
        Suppliers suppliers = new Suppliers();
        Supplier supplier = suppliers.getSupplier(shopName);

        if (supplier != null && !supplier.getShopName().equals("")) {
            System.out.println("Order processed by " + supplier.getShopName());
            System.out.println();
            System.out.println("Type of product: " + orderDTO.getProduct().getTypeOfProduct() + " || product: " + orderDTO.getProduct().getNameOfProduct());
            System.out.println("Amount: " + orderDTO.getProduct().getAmountOfProduct());
            return new OrderDTO(product);
        } else {
            System.out.println("No supplier was selected");
            return null;
        }
    }

    @Override
    public boolean ordered(Product product) {
        return false;
    }
}

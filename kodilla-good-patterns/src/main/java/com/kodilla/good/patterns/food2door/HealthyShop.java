package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.List;

public class HealthyShop implements OrderService {
    private final List<Product> productStock = new ArrayList<>();
    private int index;
    private boolean isAvailable;

    public HealthyShop() {
        productStock.add(new Product("fruits", "apple", 1200));
        productStock.add(new Product("vegetables", "potato", 500));
        productStock.add(new Product("vegetables", "carrot", 1000));
        productStock.add(new Product("fruits", "orange", 500));
        productStock.add(new Product("fruits", "lemon", 800));
    }

    public List<Product> getList() { return new ArrayList<>(productStock); }

    @Override
    public boolean process(Product product) {

        for (int i = 0; i < getList().size(); i++) {
            if (product.getNameOfProduct().equals(getList().get(i).getNameOfProduct())) {
                index = i;
                isAvailable = true;
                break;
            }
        }

        if (isAvailable && productStock.get(index).getAmountOfProduct() >= product.getAmountOfProduct()) {
            System.out.println("Product available. Fill in the delivery form.");
            return true;
        } else if (isAvailable && productStock.get(index).getAmountOfProduct() < product.getAmountOfProduct()) {
            System.out.println("Product partially available. Ask about the delivery time.");
            return false;
        } else {
            System.out.println("product unavailable - Ask about the product --> email <--");
            return false;
        }
    }
}

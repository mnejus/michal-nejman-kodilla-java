package com.kodilla.good.patterns.food2door;

public class Suppliers {
    public static final String EXTRA_FOOD_SHOP = "ExtraFoodShop -> extrafoodshop.com";
    public static final String GLUTEN_FREE_SHOP = "GlutenFreeShop -> glutenfreeshop.com";
    public static final String HEALTHY_SHOP = "HealthyShop -> healthyshop.com";

    public Supplier getSupplier(String shopName) {
        if (shopName.equalsIgnoreCase(EXTRA_FOOD_SHOP)) {
            return new ExtraFoodShop(EXTRA_FOOD_SHOP);
        } else if (shopName.equalsIgnoreCase(GLUTEN_FREE_SHOP)) {
            return new GlutenFreeShop(GLUTEN_FREE_SHOP);
        } else if (shopName.equalsIgnoreCase(HEALTHY_SHOP)) {
            return new HealthyShop(HEALTHY_SHOP);
        } else {
            System.out.println("Choose a supplier");
            return null;
        }
    }

}

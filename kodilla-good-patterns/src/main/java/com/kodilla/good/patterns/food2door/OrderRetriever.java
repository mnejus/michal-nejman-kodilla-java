//package com.kodilla.good.patterns.food2door;
//
//import java.util.Random;
//
//public class OrderRetriever {
//
//    Random r = new Random();
//
//    public Order retrieve1() {
//
//        User user = new User("Patryk Patrykowski", "patrykowski@poczta.poczta");
//        Supplier supplier = new Supplier("ExtraFoodShop", "ExtraFoodShop.com");
//        Product product = new Product("fruits", "lemon", 10);
//        String numOrder = supplier.getShopName() + (r.nextInt(100) + 1);
//
//        return new Order(user, supplier, product, numOrder);
//    }
//
//    public Order retrieve2() {
//        User user = new User("Jan Jan", "jan@poczta.poczta");
//        Supplier supplier = new Supplier("GlutenFreeShop", "GlutenFreeShop.com");
//        Product product = new Product("vegetables", "potato", 100);
//        String numOrder = supplier.getShopName() + (r.nextInt(100) + 1);
//
//        return new Order(user, supplier, product, numOrder);
//    }
//
//    public Order retrieve3() {
//
//        User user = new User("Michał Sobiela", "sobiela@poczta.poczta");
//        Supplier supplier = new Supplier("HealthyShop", "HealthyShop.com");
//        Product product = new Product("fruits", "watermelon", 20);
//        String numOrder = supplier.getShopName() + (r.nextInt(100) + 1);
//
//        return new Order(user, supplier, product, numOrder);
//    }
//}

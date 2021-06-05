package com.kodilla.good.patterns.challenges;

public class Product {
    public String categoryName;
    public String title;
    public double price;
    public boolean isAvailable;

    public Product(String categoryName, String title, double price, boolean isAvailable) {
        this.categoryName = categoryName;
        this.title = title;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}

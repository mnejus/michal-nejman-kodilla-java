package com.kodilla.good.patterns.food2door;

import java.util.Objects;

public class Product {
    private final String typeOfProduct;
    private final String nameOfProduct;
    private final double amountOfProduct;

    public Product(String typeOfProduct, String nameOfProduct, double amountOfProducts) {
        this.typeOfProduct = typeOfProduct;
        this.nameOfProduct = nameOfProduct;
        this.amountOfProduct = amountOfProducts;
    }

    public String getTypeOfProduct() {
        return typeOfProduct;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public double getAmountOfProduct() {
        return amountOfProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.amountOfProduct, amountOfProduct) == 0 && typeOfProduct.equals(product.typeOfProduct) && nameOfProduct.equals(product.nameOfProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfProduct, nameOfProduct, amountOfProduct);
    }
}

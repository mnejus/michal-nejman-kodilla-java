package com.kodilla.good.patterns.food2door;

public class Supplier {
    private String shopName;
    private String webPage;

    public Supplier(String shopName, String webPage) {
        this.shopName = shopName;
        this.webPage = webPage;
    }

    public String getShopName() {
        return shopName;
    }

    public String getWebPage() {
        return webPage;
    }
}

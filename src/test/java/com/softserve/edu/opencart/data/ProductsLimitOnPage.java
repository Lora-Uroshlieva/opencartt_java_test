package com.softserve.edu.opencart.data;

public enum  ProductsLimitOnPage {
    LIMIT_15("15"),
    LIMIT_25("25"),
    LIMIT_50("50"),
    LIMIT_75("75"),
    LIMIT_100("100");


    private String name;

    private ProductsLimitOnPage(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

package com.example.bt1112.entity;

public class Product {
    private int id;
    private String name;
    private int price;
    private String description;
    private String manufacturer;
    private int categoryId;

    public Product(int id, String name, int price, String description, String manufacturer, int categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.manufacturer = manufacturer;
        this.categoryId = categoryId;
    }

    public Product(String name, int price, String description, String manufacturer, int categoryId) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.manufacturer = manufacturer;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getCategoryId() {
        return categoryId;
    }
}

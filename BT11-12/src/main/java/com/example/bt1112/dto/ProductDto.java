package com.example.bt1112.dto;

public class ProductDto {
    private int id;
    private String name;
    private int price;
    private String description;
    private String manufacturer;
    private String category;

    public ProductDto(int id, String name, int price, String description, String manufacturer, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.manufacturer = manufacturer;
        this.category = category;
    }

    public ProductDto(String name, int price, String description, String manufacturer, String category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.manufacturer = manufacturer;
        this.category = category;
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

    public String getCategory() {
        return category;
    }
}

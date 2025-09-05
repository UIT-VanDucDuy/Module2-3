package com.example.btthem.dto;

public class ProductDto {
    private String id;
    private String name;
    private String unit;
    private double price;
    private String type;
    private String date;

    public ProductDto(String id, String name, String unit, double price,String type, String date) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.unit = unit;
        this.price = price;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getUnit() {
        return unit;
    }

    public double getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }
}

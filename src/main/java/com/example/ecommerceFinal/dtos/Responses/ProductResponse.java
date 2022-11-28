package com.example.ecommerceFinal.dtos.Responses;

public class ProductResponse {

    private String name;
    private String description;
    private int price;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
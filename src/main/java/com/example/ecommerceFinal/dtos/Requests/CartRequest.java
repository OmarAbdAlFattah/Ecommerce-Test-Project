package com.example.ecommerceFinal.dtos.Requests;

public class CartRequest {

    private Long id;
    private short totalPrice;
    private short totalQuantity;

    public Long getId() {
        return id;
    }
    public short getTotalPrice() {
        return totalPrice;
    }
    public short getTotalQuantity() {
        return totalQuantity;
    }
}

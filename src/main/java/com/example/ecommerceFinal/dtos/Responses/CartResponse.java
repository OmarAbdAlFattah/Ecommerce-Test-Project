package com.example.ecommerceFinal.dtos.Responses;

public class CartResponse {


    private short totalPrice;
    private short totalQuantity;
    public short getTotalPrice() {
        return totalPrice;
    }

    public short getTotalQuantity() {
        return totalQuantity;
    }
    public void setTotalPrice(short totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setTotalQuantity(short totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

}

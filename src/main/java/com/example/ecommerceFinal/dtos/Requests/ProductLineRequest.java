package com.example.ecommerceFinal.dtos.Requests;

public class ProductLineRequest {
    private short quantity;
    private Long cartId;
    private Long productId;

    public short getQuantity() {
        return quantity;
    }

    public Long getCartId() {
        return cartId;
    }

    public Long getProductId() {
        return productId;
    }
}

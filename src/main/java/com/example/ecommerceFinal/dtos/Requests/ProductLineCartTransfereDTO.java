package com.example.ecommerceFinal.dtos.Requests;

public class ProductLineCartTransfereDTO {
    private Long cartId;
    private Long productLineId;

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getProductLineId() {
        return productLineId;
    }

    public void setProductLineId(Long productLineId) {
        this.productLineId = productLineId;
    }
}

package com.example.ecommerceFinal.dtos.Requests;

public class ProductToProductLineDTO {
    private Long productId;

    private short quantity;
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

}

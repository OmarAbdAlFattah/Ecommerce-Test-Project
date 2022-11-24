package com.example.ecommerceFinal.service;

import com.example.ecommerceFinal.dtos.Requests.CartRequest;
import com.example.ecommerceFinal.entity.Cart;
import com.example.ecommerceFinal.repos.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final CartRepo cartRepo;
    @Autowired
    public CartService(CartRepo cartRepo) {
        this.cartRepo = cartRepo;
    }

    public void addCart(CartRequest cartRequest){
        Cart cart = new Cart();
        cart.setTotalPrice(cartRequest.getTotalPrice());
        cart.setTotalQuantity(cartRequest.getTotalQuantity());
        cartRepo.save(cart);
    }
}

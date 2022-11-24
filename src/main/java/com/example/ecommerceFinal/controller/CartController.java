package com.example.ecommerceFinal.controller;

import com.example.ecommerceFinal.dtos.Requests.CartRequest;
import com.example.ecommerceFinal.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/ecommerce/cart")
@RestController
public class CartController {
    private final CartService cartService;
    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public void addCart(@RequestBody CartRequest cartRequest){
        cartService.addCart(cartRequest);
    }
}

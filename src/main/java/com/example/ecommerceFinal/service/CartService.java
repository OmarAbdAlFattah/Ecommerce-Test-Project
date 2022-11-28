package com.example.ecommerceFinal.service;

import com.example.ecommerceFinal.dtos.Requests.CartRequest;
import com.example.ecommerceFinal.dtos.Responses.CartResponse;
import com.example.ecommerceFinal.entity.Cart;
import com.example.ecommerceFinal.repos.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    public List<Cart> listAllCarts() {
        return cartRepo.findAll();
    }


    public CartResponse getCart(Long id) {
        Optional<Cart> cart = cartRepo.findById(id);
        if (cart.isPresent()){
            Cart foundCart = cart.get();
            CartResponse cartResponse = new CartResponse();
            cartResponse.setTotalPrice(foundCart.getTotalPrice());
            cartResponse.setTotalQuantity(foundCart.getTotalQuantity());
            return cartResponse;
        }
        System.err.println("COULDN'T FIND cart IN DATABASE");
        return null;
    }

    public void saveCart(Long id, CartRequest cartRequest) {
        try {
            Cart foundCart = cartRepo.findById(id).get();
            foundCart.setTotalPrice(cartRequest.getTotalPrice());
            foundCart.setTotalQuantity(cartRequest.getTotalQuantity());
            cartRepo.save(foundCart);
        }catch (NoSuchElementException e){}
    }

    public void deleteCart(Long id) {
        try {
            cartRepo.findById(id);
            cartRepo.deleteById(id);
        } catch (NoSuchElementException e){}
    }
}

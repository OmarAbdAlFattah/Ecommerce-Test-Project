package com.example.ecommerceFinal.controller;

import com.example.ecommerceFinal.dtos.Requests.CartRequest;
import com.example.ecommerceFinal.dtos.Requests.ProductRequest;
import com.example.ecommerceFinal.dtos.Responses.CartResponse;
import com.example.ecommerceFinal.dtos.Responses.ProductResponse;
import com.example.ecommerceFinal.entity.Cart;
import com.example.ecommerceFinal.entity.Product;
import com.example.ecommerceFinal.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RequestMapping("api/ecommerce/cart")
@RestController
public class CartController {
    private final CartService cartService;
    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public void addCart(@RequestBody CartRequest cartRequest){
        cartService.addCart(cartRequest);
    }

    @GetMapping("")
    public ResponseEntity<List<Cart>> list(){
        return new ResponseEntity <> (cartService.listAllCarts(), HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<CartResponse> showCart(@PathVariable Long id){
        try{
            return new ResponseEntity <> (cartService.getCart(id), HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity <> (HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public void updateCart(@RequestBody CartRequest cartRequest, @PathVariable Long id) {
        cartService.saveCart(id, cartRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteCart(Long id){
        cartService.deleteCart(id);
    }
}

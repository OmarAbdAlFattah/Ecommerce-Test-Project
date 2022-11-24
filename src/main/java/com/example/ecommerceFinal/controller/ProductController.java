package com.example.ecommerceFinal.controller;

import com.example.ecommerceFinal.dtos.Requests.ProductRequest;
import com.example.ecommerceFinal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/ecommerce/product")
@RestController
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public void addProduct(@RequestBody ProductRequest productRequest){
        productService.addNewProduct(productRequest);
    }
}

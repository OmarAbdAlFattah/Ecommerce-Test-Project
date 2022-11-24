package com.example.ecommerceFinal.controller;

import com.example.ecommerceFinal.dtos.Requests.ProductLineRequest;
import com.example.ecommerceFinal.service.ProductLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/ecommerce/product_line")
public class ProductLineController {
    private final ProductLineService productLineService;
    @Autowired
    public ProductLineController(ProductLineService productLineService) {
        this.productLineService = productLineService;
    }

    @PostMapping
    public void addProductLine(@RequestBody ProductLineRequest productLineRequest){
        productLineService.addNewProductLine(productLineRequest);
    }
}

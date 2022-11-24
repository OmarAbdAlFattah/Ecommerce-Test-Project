package com.example.ecommerceFinal.service;

import com.example.ecommerceFinal.dtos.Requests.ProductLineRequest;
import com.example.ecommerceFinal.dtos.Requests.ProductRequest;
import com.example.ecommerceFinal.entity.Product;
import com.example.ecommerceFinal.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepo productRepo;
    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public void addNewProduct(ProductRequest productRequest){
        Product product = new Product();
        product.setDescription(productRequest.getDescription());
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        productRepo.save(product);
    }

}

package com.example.ecommerceFinal.service;

import com.example.ecommerceFinal.dtos.Requests.ProductLineRequest;
import com.example.ecommerceFinal.entity.Product;
import com.example.ecommerceFinal.entity.ProductLine;
import com.example.ecommerceFinal.repos.ProductLineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductLineService {
    private final ProductLineRepo productLineRepo;
    @Autowired
    public ProductLineService(ProductLineRepo productLineRepo) {
        this.productLineRepo = productLineRepo;
    }

    public void addNewProductLine(ProductLineRequest productLineRequest){
        ProductLine productLine = new ProductLine();
        productLine.setQuantity(productLineRequest.getQuantity());
        productLineRepo.save(productLine);
    }
}

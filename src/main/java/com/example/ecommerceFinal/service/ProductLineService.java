package com.example.ecommerceFinal.service;

import com.example.ecommerceFinal.dtos.Requests.ProductLineRequest;
import com.example.ecommerceFinal.dtos.Responses.ProductLineResponse;
import com.example.ecommerceFinal.entity.ProductLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductLineService {
    private final com.example.ecommerceFinal.repos.ProductLineRepo productLineRepo;
    @Autowired
    public ProductLineService(com.example.ecommerceFinal.repos.ProductLineRepo productLineRepo) {
        this.productLineRepo = productLineRepo;
    }

    public void addNewProductLine(ProductLineRequest productLineRequest){
        ProductLine productLine = new ProductLine();
        productLine.setQuantity(productLineRequest.getQuantity());
        productLineRepo.save(productLine);
    }

    public ProductLineResponse getProductLine(Long id){
        Optional<ProductLine> productLine = productLineRepo.findById(id);
        if(productLine.isPresent()){
            ProductLine foundProductLine = productLine.get();
            ProductLineResponse productLineResponse = new ProductLineResponse();
            productLineResponse.setQuantity(foundProductLine.getQuantity());
            return productLineResponse;
        }
        return null;
    }

    public List<ProductLine> listAllProductLines(){
        return productLineRepo.findAll();
    }

    public void saveProductLine(Long id, ProductLineRequest productLineRequest) {
        try {
            ProductLine existingProductLine = productLineRepo.findById(id).get();
            existingProductLine.setQuantity(productLineRequest.getQuantity());
            productLineRepo.save(existingProductLine);
        } catch (NoSuchElementException e) {}
    }

    public void deleteProductLine(Long id) {
        try{
            productLineRepo.findById(id).get();
            productLineRepo.deleteById(id);
        }catch (NoSuchElementException e){}
    }
}

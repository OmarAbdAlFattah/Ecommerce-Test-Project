package com.example.ecommerceFinal.service;

import com.example.ecommerceFinal.dtos.Requests.ProductLineRequest;
import com.example.ecommerceFinal.dtos.Requests.ProductToProductLineDTO;
import com.example.ecommerceFinal.dtos.Responses.ProductLineResponse;
import com.example.ecommerceFinal.entity.Product;
import com.example.ecommerceFinal.entity.ProductLine;
import com.example.ecommerceFinal.repos.ProductLineRepo;
import com.example.ecommerceFinal.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductLineService {
    private final com.example.ecommerceFinal.repos.ProductLineRepo productLineRepo;
    private final com.example.ecommerceFinal.repos.ProductRepo productRepo;
    @Autowired
    public ProductLineService(ProductLineRepo productLineRepo, ProductRepo productRepo) {
        this.productLineRepo = productLineRepo;
        this.productRepo = productRepo;
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
        System.err.println("COULNND'NT FIND product_line with id " + id + "IN DATABASE");

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

    public void saveProductToProductLine(ProductToProductLineDTO productToProductLineDTO) {
        Product product = productRepo.findById(productToProductLineDTO.getProductId()).get();
        ProductLine productLine = new ProductLine();

        productLine.setQuantity(productToProductLineDTO.getQuantity());
        productLine.setProduct(product);
        productLineRepo.save(productLine);
    }
}

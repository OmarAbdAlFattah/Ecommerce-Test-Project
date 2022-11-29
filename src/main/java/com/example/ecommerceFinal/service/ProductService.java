package com.example.ecommerceFinal.service;

import com.example.ecommerceFinal.dtos.Requests.ProductLineRequest;
import com.example.ecommerceFinal.dtos.Requests.ProductRequest;
import com.example.ecommerceFinal.dtos.Responses.ProductResponse;
import com.example.ecommerceFinal.entity.Product;
import com.example.ecommerceFinal.entity.ProductLine;
import com.example.ecommerceFinal.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    public List<Product> listAllProduct() {
        return productRepo.findAll();
    }

    public ProductResponse getProduct(Long id) {
        Optional<Product> product = productRepo.findById(id);
        if (product.isPresent()){
            Product foundProduct = product.get();
            ProductResponse productResponse = new ProductResponse();
            productResponse.setName(foundProduct.getName());
            productResponse.setDescription(foundProduct.getDescription());
            productResponse.setPrice(foundProduct.getPrice());
            return productResponse;
        }
        System.err.println("COULDN'T FIND product  " + id + "IN DATABASE!");
        return null;
    }

    public void saveProduct(Long id, ProductRequest productRequest) {
        try {
            Product foundProduct = productRepo.findById(id).get();
            foundProduct.setName(productRequest.getName());
            foundProduct.setDescription(productRequest.getDescription());
            foundProduct.setPrice(productRequest.getPrice());
            productRepo.save(foundProduct);
        } catch (NoSuchElementException e) {}
    }

    public void deleteProduct(Long id) {
        try{
            productRepo.findById(id).get();
            productRepo.deleteById(id);
        } catch (NoSuchElementException e){}

    }
}

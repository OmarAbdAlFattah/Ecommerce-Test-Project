package com.example.ecommerceFinal.controller;

import com.example.ecommerceFinal.dtos.Requests.ProductLineRequest;
import com.example.ecommerceFinal.dtos.Requests.ProductRequest;
import com.example.ecommerceFinal.dtos.Responses.ProductLineResponse;
import com.example.ecommerceFinal.dtos.Responses.ProductResponse;
import com.example.ecommerceFinal.entity.Product;
import com.example.ecommerceFinal.entity.ProductLine;
import com.example.ecommerceFinal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RequestMapping("api/ecommerce/product")
@RestController
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody ProductRequest productRequest){
        System.out.println(productRequest.getDescription());
        productService.addNewProduct(productRequest);
    }
    @GetMapping("")
    public ResponseEntity<List<Product>> list(){
        return new ResponseEntity <> (productService.listAllProduct(), HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductResponse> showProductLine(@PathVariable Long id){
        try{
            return new ResponseEntity <> (productService.getProduct(id), HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity <> (HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public void updateProduct(@RequestBody ProductRequest productRequest, @PathVariable Long id) {
        productService.saveProduct(id, productRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(Long id){
        productService.deleteProduct(id);
    }
}

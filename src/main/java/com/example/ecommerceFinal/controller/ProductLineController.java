package com.example.ecommerceFinal.controller;

import com.example.ecommerceFinal.dtos.Requests.ProductLineRequest;
import com.example.ecommerceFinal.dtos.Responses.ProductLineResponse;
import com.example.ecommerceFinal.entity.ProductLine;
import com.example.ecommerceFinal.service.ProductLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.List;

@RestController
@RequestMapping("api/ecommerce/product_line")
public class ProductLineController {
    private final ProductLineService productLineService;
    @Autowired
    public ProductLineController(ProductLineService productLineService) {
        this.productLineService = productLineService;
    }

    @PostMapping("/add")
    public void addProductLine(@RequestBody ProductLineRequest productLineRequest){
        productLineService.addNewProductLine(productLineRequest);
    }

    @GetMapping("")
    public ResponseEntity<List<ProductLine>> list(){
        return new ResponseEntity <> (productLineService.listAllProductLines(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductLineResponse> showProductLine(@PathVariable Long id){
        try{
            return new ResponseEntity <> (productLineService.getProductLine(id), HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity <> (HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public void updateProductLine(@RequestBody ProductLineRequest productLineRequest, @PathVariable Long id) {
        productLineService.saveProductLine(id, productLineRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteProductLine(Long id){
        productLineService.deleteProductLine(id);
    }
}

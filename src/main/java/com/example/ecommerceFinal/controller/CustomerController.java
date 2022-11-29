package com.example.ecommerceFinal.controller;

import com.example.ecommerceFinal.dtos.Requests.CartRequest;
import com.example.ecommerceFinal.dtos.Requests.CustomerRequest;
import com.example.ecommerceFinal.dtos.Responses.CustomerResponse;
import com.example.ecommerceFinal.entity.Customer;
import com.example.ecommerceFinal.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RequestMapping("api/ecommerce/customer")
@RestController
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping("/add")
    public void addCustomer(@RequestBody CustomerRequest customerRequest){
        customerService.addNewCustomer(customerRequest);
    }

    @GetMapping("")
    public ResponseEntity<List<Customer>> viewAllCustomers(){
        return new ResponseEntity<>(customerService.listAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> showCustomer(@PathVariable Long id){
        try{
            return new ResponseEntity<>(customerService.getCustomer(id), HttpStatus.OK);
        } catch (NoSuchElementException e){return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
    }

    @PutMapping("/{id}")
    public void updateCustomer(@RequestBody CustomerRequest customerRequest, @PathVariable Long id) {
        customerService.saveCustomer(id, customerRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(Long id) {
        customerService.deleteCustomer(id);
    }
}

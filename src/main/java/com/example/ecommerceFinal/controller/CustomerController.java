package com.example.ecommerceFinal.controller;

import com.example.ecommerceFinal.dtos.Requests.CustomerRequest;
import com.example.ecommerceFinal.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        System.out.println(customerRequest.getEmail());
        System.out.println(customerRequest.getName());
        customerService.addNewCustomer(customerRequest);
    }
}

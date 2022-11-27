package com.example.ecommerceFinal.service;

import com.example.ecommerceFinal.dtos.Requests.CustomerRequest;
import com.example.ecommerceFinal.entity.Customer;
import com.example.ecommerceFinal.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;
    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public void addNewCustomer(CustomerRequest customerRequest){
        Customer customer = new Customer();
        customer.setName(customerRequest.getName());
        customer.setEmail(customerRequest.getEmail());
        customerRepo.save(customer);
    }
}

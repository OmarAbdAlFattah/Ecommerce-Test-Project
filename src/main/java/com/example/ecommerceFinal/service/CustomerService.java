package com.example.ecommerceFinal.service;

import com.example.ecommerceFinal.dtos.Requests.CustomerRequest;
import com.example.ecommerceFinal.dtos.Responses.CustomerResponse;
import com.example.ecommerceFinal.entity.Customer;
import com.example.ecommerceFinal.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private final CustomerRepo customerRepo;
    @Autowired
    private final CartService cartService;

    public CustomerService(CustomerRepo customerRepo, CartService cartService) {
        this.customerRepo = customerRepo;
        this.cartService = cartService;
    }

    public void addNewCustomer(CustomerRequest customerRequest){
        Customer customer = new Customer();
        customer.setName(customerRequest.getName());
        customer.setEmail(customerRequest.getEmail());
        cartService.addCustomerToCart(customer);
        customerRepo.save(customer);
    }

    public List<Customer> listAllCustomers() {
        return customerRepo.findAll();
    }

    public CustomerResponse getCustomer(Long id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if (customer.isPresent()){
            Customer foundCustomer = customer.get();
            CustomerResponse customerResponse = new CustomerResponse();
            customerResponse.setName(foundCustomer.getName());
            customerResponse.setEmail(foundCustomer.getEmail());
            return customerResponse;
        }
        System.err.println("COULNND'NT FIND customer with id " + id + "IN DATABASE");
        return null;
    }

    public void saveCustomer(Long id, CustomerRequest customerRequest) {
        try{
            Customer foundCustomer = customerRepo.findById(id).get();
            foundCustomer.setName(customerRequest.getName());
            foundCustomer.setEmail(customerRequest.getEmail());
            customerRepo.save(foundCustomer);
        } catch (NoSuchElementException e){}
    }

    public void deleteCustomer(Long id) {
        try{
            customerRepo.findById(id);
            customerRepo.deleteById(id);
        } catch (NoSuchElementException e){}
    }
}

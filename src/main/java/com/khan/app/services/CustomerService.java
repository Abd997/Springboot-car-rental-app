package com.khan.app.services;

import com.khan.app.entities.Customers;
import com.khan.app.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomerService {
    
    private final CustomerRepo customerRepo;
    
    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }
    
    public void addUser(String email, String password) {
        Customers customer = new Customers();
        customer.setEmail(email);
        customer.setPassword(password);
        customerRepo.save(customer);
    }
    
    public boolean checkEmail(String email) {
        Customers customer = customerRepo.findByEmail(email);
        return !Objects.isNull(customer);
    }
    
    public boolean authenticateUser(String email, String password) {
        Customers customer = customerRepo.findByEmailAndPassword(email, password);
        return !Objects.isNull(customer);
    }
}

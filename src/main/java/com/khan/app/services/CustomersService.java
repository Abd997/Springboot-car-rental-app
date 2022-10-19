package com.khan.app.services;

import com.khan.app.entities.Customer;
import com.khan.app.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomersService {
    
    private final CustomerRepo customerRepo;
    
    @Autowired
    public CustomersService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }
    
    public void addUser(Customer customer) {
        customerRepo.save(customer);
    }
    
    public boolean checkEmail(String email) {
        Customer customer = customerRepo.findByEmail(email);
        return !Objects.isNull(customer);
    }
    
    public boolean authenticateUser(String email, String password) {
        Customer customer = customerRepo.findByEmailAndPassword(email, password);
        return !Objects.isNull(customer);
    }
}

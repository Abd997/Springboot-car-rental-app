package com.khan.app.controllers;

import com.khan.app.entities.Customer;
import com.khan.app.services.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/customers")
public class CustomersRestController {
    
    private final CustomersService customersService;
    
    @Autowired
    public CustomersRestController(CustomersService customersService) {
        this.customersService = customersService;
    }
    
    @PostMapping
    public ResponseEntity<?> addCustomer(
            @RequestBody Map<String, Object> payload
    ) {
        boolean emailExists = customersService.checkEmail((String) payload.get("email"));
        if (emailExists) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Email already exists");
        }
        Customer customer = new Customer();
        customer.setEmail((String) payload.get("email"));
        customer.setPassword((String) payload.get("password"));
        customer.setAddress((String) payload.get("address"));
        customer.setFirstName((String) payload.get("firstName"));
        customer.setLastName((String) payload.get("lastName"));
        customer.setCity((String) payload.get("city"));
        customer.setState((String) payload.get("state"));
        customersService.addUser(customer);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Customer registered");
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> getCustomer(
            @RequestBody Map<String, Object> payload
    ) {
        boolean customerExists = customersService.authenticateUser(
                (String) payload.get("email"),
                (String) payload.get("password")
        );
        if (customerExists) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}

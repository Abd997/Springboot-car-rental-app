package com.khan.app.controllers;

import com.khan.app.services.CustomerService;
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
    
    private final CustomerService customerService;
    
    @Autowired
    public CustomersRestController(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    @PostMapping
    public ResponseEntity<?> addCustomer(
            @RequestBody Map<String, Object> payload
    ) {
        boolean emailExists = customerService.checkEmail((String) payload.get("email"));
        if (!emailExists) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Email already exists");
        }
        customerService.addUser(
                (String) payload.get("email"),
                (String) payload.get("password")
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Customer registered");
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> getCustomer(
            @RequestBody Map<String, Object> payload
    ) {
        boolean customerExists = customerService.authenticateUser(
                (String) payload.get("email"),
                (String) payload.get("password")
        );
        if (customerExists) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}

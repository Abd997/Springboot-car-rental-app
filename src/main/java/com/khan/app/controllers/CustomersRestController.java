package com.khan.app.controllers;

import com.khan.app.entities.Customer;
import com.khan.app.services.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        Customer customer = createCustomer(payload);
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
    
    @DeleteMapping
    public String delCustomer(
            @RequestBody Map<String, Object> payload
    ) {
        Customer customer = customersService.findCustomer((String) payload.get("email"));
        customersService.delUser(customer);
        return "Customer deleted";
    }
    
    @PutMapping
    public String updateCustomer(
            @RequestBody Map<String, Object> payload
    ) {
        Customer customer = createCustomer(payload);
        customersService.updateUser(customer);
        return "User updated";
    }
    
    private Customer createCustomer(@RequestBody Map<String, Object> payload) {
        Customer customer = new Customer();
        customer.setEmail((String) payload.get("email"));
        customer.setPassword((String) payload.get("password"));
        customer.setAddress((String) payload.get("address"));
        customer.setFirstName((String) payload.get("firstName"));
        customer.setLastName((String) payload.get("lastName"));
        customer.setCity((String) payload.get("city"));
        customer.setState((String) payload.get("state"));
        return customer;
    }
    
    @ExceptionHandler({Exception.class})
    public void handleException() {
        System.out.println("Internal error");
    }
}

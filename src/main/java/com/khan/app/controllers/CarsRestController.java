package com.khan.app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarsRestController {
    
    @GetMapping
    public ResponseEntity<?> getCar() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("car");
    }
    
    @PostMapping
    public ResponseEntity<?> addCar() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("car");
    }
}

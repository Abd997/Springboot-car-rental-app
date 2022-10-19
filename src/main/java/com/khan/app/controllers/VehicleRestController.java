package com.khan.app.controllers;

import com.khan.app.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleRestController {
    
    private final BookingService bookingService;
    
    @Autowired
    public VehicleRestController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    
    @PostMapping("rent-vehicle")
    public ResponseEntity<?> rentCar(@RequestParam String user, @RequestParam int vehicleId) {
        bookingService.genBooking(user, vehicleId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Booking generated");
    }
    
    @ExceptionHandler({Exception.class})
    public void handleException(Exception e) {
        System.out.println("Internal error");
        System.out.println(e);
    }
}

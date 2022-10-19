package com.khan.app.controllers;

import com.khan.app.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingsController {
    
    private final BookingService bookingService;
    
    @Autowired
    public BookingsController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    
    @GetMapping("/bookings")
    public String getBookings(@RequestParam String user, Model model) {
        model.addAttribute("bookings", bookingService.getBookings(user));
        return "bookings-page";
    }
}

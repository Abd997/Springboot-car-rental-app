package com.khan.app.controllers;

import com.khan.app.entities.Vehicle;
import com.khan.app.services.VehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class HomeController {
    
    private final VehiclesService vehiclesService;
    
    @Autowired
    public HomeController(VehiclesService vehiclesService) {
        this.vehiclesService = vehiclesService;
    }
    
    @GetMapping("/home")
    public String getUserHomePage(Model model) {
        List<Vehicle> vehicles = vehiclesService.getAllVehicles();
        model.addAttribute("vehicles", vehicles);
        return "user-home";
    }
    
    @PostMapping(value = "/home", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String getUserHomePageWithFilter(Model model, @RequestBody MultiValueMap<String, String> formData) {
        List<Vehicle> vehicles = vehiclesService.getVehiclesByCity(formData.get("location").get(0));
        model.addAttribute("vehicles", vehicles);
        return "user-home";
    }
    
    @ExceptionHandler
    public void handleException() {
        System.out.println("Internal error");
    }
}

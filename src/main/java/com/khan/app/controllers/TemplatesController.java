package com.khan.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplatesController {
    
    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }
    
    @GetMapping("/register")
    public String getRegisterPage() {
        return "register";
    }
    
    @ExceptionHandler
    public void handleException() {
        System.out.println("Internal error");
    }
}

package com.khan.app.services;

import com.khan.app.repos.CarsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarsService {
    
    private final CarsRepo carsRepo;
    
    @Autowired
    public CarsService(CarsRepo carsRepo) {
        this.carsRepo = carsRepo;
    }
    
    
}

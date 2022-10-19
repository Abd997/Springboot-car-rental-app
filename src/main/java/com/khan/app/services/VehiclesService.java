package com.khan.app.services;

import com.khan.app.entities.Vehicle;
import com.khan.app.repos.VehiclesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiclesService {
    
    private final VehiclesRepo vehiclesRepo;
    
    @Autowired
    public VehiclesService(VehiclesRepo vehiclesRepo) {
        this.vehiclesRepo = vehiclesRepo;
    }
    
    public void addVehicle(Vehicle vehicle) {
        vehiclesRepo.save(vehicle);
    }
    
    public List<Vehicle> getAllVehicles() {
        return vehiclesRepo.findAll();
    }
    
    public List<Vehicle> getVehiclesByCity(String location) {
        return vehiclesRepo.findVehicleByCity(location);
    }
}

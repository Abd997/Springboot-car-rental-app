package com.khan.app;

import com.khan.app.entities.RentalLot;
import com.khan.app.entities.Vehicle;
import com.khan.app.services.VehiclesService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }
    
    @Bean
    public CommandLineRunner insertData(VehiclesService vehiclesService) {
        return args -> {
            for (int i = 0; i < 5; i++) {
                RentalLot rentalLot = new RentalLot();
                rentalLot.setLotName("lot");
                rentalLot.setAddress("address");
                rentalLot.setCity("lahore");
                rentalLot.setState("punjab");
                
                Vehicle vehicle = new Vehicle();
                vehicle.setCompany("Toyota");
                vehicle.setFuelType("petrol");
                vehicle.setYearBuilt(2018);
                vehicle.setRate(100);
                vehicle.setRentalLot(rentalLot);
                vehiclesService.addVehicle(vehicle);
            }
            
            for (int i = 0; i < 5; i++) {
                RentalLot rentalLot = new RentalLot();
                rentalLot.setLotName("lot");
                rentalLot.setAddress("address");
                rentalLot.setCity("karachi");
                rentalLot.setState("sindh");
                
                Vehicle vehicle = new Vehicle();
                vehicle.setCompany("Suzuki");
                vehicle.setFuelType("diesel");
                vehicle.setYearBuilt(2020);
                vehicle.setRate(60);
                vehicle.setRentalLot(rentalLot);
                vehiclesService.addVehicle(vehicle);
            }
        };
    }
}

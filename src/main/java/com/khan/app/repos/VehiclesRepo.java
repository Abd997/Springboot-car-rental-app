package com.khan.app.repos;

import com.khan.app.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehiclesRepo extends JpaRepository<Vehicle, Long> {
    
    @Query("select v from Vehicle v where v.rentalLot.city = :city")
    List<Vehicle> findVehicleByCity(@Param("city") String city);
}

package com.khan.app.repos;

import com.khan.app.entities.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepo extends JpaRepository<Cars, Long> {
}

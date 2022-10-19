package com.khan.app.repos;

import com.khan.app.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingRepo extends JpaRepository<Booking, Long> {
    
    @Query("select b from Booking b where b.customer.email = :email")
    List<Booking> findAllByCustomerEmail(@Param("email") String email);
}

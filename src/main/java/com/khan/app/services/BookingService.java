package com.khan.app.services;

import com.khan.app.entities.Booking;
import com.khan.app.entities.Customer;
import com.khan.app.entities.Vehicle;
import com.khan.app.repos.BookingRepo;
import com.khan.app.repos.CustomerRepo;
import com.khan.app.repos.VehiclesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BookingService {
    
    private final BookingRepo bookingRepo;
    private final VehiclesRepo vehiclesRepo;
    private final CustomerRepo customerRepo;
    
    @Autowired
    public BookingService(BookingRepo bookingRepo, VehiclesRepo vehiclesRepo, CustomerRepo customerRepo) {
        this.bookingRepo = bookingRepo;
        this.vehiclesRepo = vehiclesRepo;
        this.customerRepo = customerRepo;
    }
    
    public void genBooking(String userEmail, long vehicleId) {
        Vehicle vehicle = vehiclesRepo.findById(vehicleId).orElse(null);
        if (Objects.isNull(vehicle)) {
            return;
        }
        Customer customer = customerRepo.findByEmail(userEmail);
        if (Objects.isNull(customer)) {
            return;
        }
        Booking booking = new Booking();
        booking.setVehicle(vehicle);
        booking.setCustomer(customer);
        bookingRepo.save(booking);
    }
    
    public List<Booking> getBookings(String userEmail) {
        return bookingRepo.findAllByCustomerEmail(userEmail);
    }
}

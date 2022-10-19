package com.khan.app.repos;

import com.khan.app.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
    
    @Query("select c from Customer c where c.email = :email and c.password = :password")
    Customer findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
    
    @Query("select c from Customer c where c.email = :email")
    Customer findByEmail(@Param("email") String email);
}

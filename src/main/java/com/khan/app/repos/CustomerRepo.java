package com.khan.app.repos;

import com.khan.app.entities.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepo extends JpaRepository<Customers, Long> {
    
    @Query("select c from Customers c where c.email = :email and c.password = :password")
    Customers findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
    
    @Query("select c from Customers c where c.email = :email")
    Customers findByEmail(@Param("email") String email);
}

package com.khan.app.entities;

import javax.persistence.*;

@Entity
@Table
public class Booking {
    private Long id;
    
    private Vehicle car;
    
    @OneToOne
    public Vehicle getCar() {
        return car;
    }
    
    public void setCar(Vehicle car) {
        this.car = car;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
}

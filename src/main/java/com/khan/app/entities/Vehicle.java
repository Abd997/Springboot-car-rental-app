package com.khan.app.entities;

import javax.persistence.*;

@Entity
@Table
public class Vehicle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String company;
    
    @Column
    private int yearBuilt;
    
    @Column
    private String fuelType;
    
    @Column
    private int rate;
    
    @OneToOne(cascade = {CascadeType.ALL})
    private RentalLot rentalLot;
    
    public RentalLot getRentalLot() {
        return rentalLot;
    }
    
    public void setRentalLot(RentalLot rentalLot) {
        this.rentalLot = rentalLot;
    }
    
    public String getCompany() {
        return company;
    }
    
    public void setCompany(String company) {
        this.company = company;
    }
    
    public int getYearBuilt() {
        return yearBuilt;
    }
    
    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }
    
    public String getFuelType() {
        return fuelType;
    }
    
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
    
    public int getRate() {
        return rate;
    }
    
    public void setRate(int rate) {
        this.rate = rate;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
}

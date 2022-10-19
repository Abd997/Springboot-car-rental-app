package com.khan.app.entities;

import javax.persistence.*;

@Entity
@Table
public class RentalLot {
    
    private Long id;
    
    @Column
    private String lotName;
    
    @Column
    private String address;
    
    @Column
    private String city;
    
    @Column
    private String state;
    
    public String getLotName() {
        return lotName;
    }
    
    public void setLotName(String lotName) {
        this.lotName = lotName;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
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

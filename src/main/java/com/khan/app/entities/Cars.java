package com.khan.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Cars {
    private Long id;
    
    private String name;
    
    private int price;
    
    @Column
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column
    public int getPrice() {
        return price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    @Id
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
}

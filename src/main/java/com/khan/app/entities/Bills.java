package com.khan.app.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Bills {
    private Long id;
    
    private Cars car;
    
    @OneToOne
    public Cars getCar() {
        return car;
    }
    
    public void setCar(Cars car) {
        this.car = car;
    }
    
    @Id
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
}

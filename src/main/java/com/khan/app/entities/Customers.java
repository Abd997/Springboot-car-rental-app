package com.khan.app.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Customers {
    private Long id;
    
    private String email;
    private String password;
    
    private List<Bills> bill;
    
    @OneToMany
    public List<Bills> getBill() {
        return bill;
    }
    
    public void setBill(List<Bills> bill) {
        this.bill = bill;
    }
    
    @Column
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Column
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Id
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
}

package com.jpa.one2many.cars.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String name;

    public Car() {
    }
    
    public Car(String name, Price price, Driver driver) {
        this.name = name;
        this.price = price;
        this.driver = driver;
    }
    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "price_id")
    private Price price;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    
}

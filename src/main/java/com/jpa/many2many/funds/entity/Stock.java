package com.jpa.many2many.funds.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "stocks")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String symbol;

    @ManyToMany(mappedBy = "stocks")
    @JsonIgnoreProperties(value = {"stocks"})
    private Set<Fund> funds = new LinkedHashSet<>();
    
    public Stock(String symbol) {
        this.symbol = symbol;
    }

    public Stock() {
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Set<Fund> getFunds() {
        return funds;
    }

    public void setFunds(Set<Fund> funds) {
        this.funds = funds;
    }

    @Override
    public String toString() {
        return "Stock{" + "id=" + id + ", symbol=" + symbol + '}';
    }
    
    

}   

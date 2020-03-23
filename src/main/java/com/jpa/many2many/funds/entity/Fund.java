package com.jpa.many2many.funds.entity;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "funds")
public class Fund { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column
    private String name;
    
    @ManyToMany()
    @JoinTable(name = "fund_stock", 
            joinColumns = {
                @JoinColumn(name = "fund_id", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                @JoinColumn(name = "stock_id", nullable = false, updatable = false)
            }
    )
    private Set<Stock> stocks = new LinkedHashSet<>();

    public Fund() {
    }
    
    public Fund(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }

    @Override
    public String toString() {
        return "Fund{" + "id=" + id + ", name=" + name + '}';
    }

    
    
    
}

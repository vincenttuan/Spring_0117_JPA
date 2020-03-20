package com.jpa.one2many.cars.service;

import com.jpa.one2many.cars.dao.CarsRepository;
import com.jpa.one2many.cars.dao.DriversRepository;
import com.jpa.one2many.cars.dao.PricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("carsService")
public class CarsService {
    @Autowired
    private CarsRepository carsRepository;
    
    @Autowired
    private DriversRepository driversRepository;

    @Autowired
    private PricesRepository pricesRepository;

    public CarsRepository getCarsRepository() {
        return carsRepository;
    }

    public DriversRepository getDriversRepository() {
        return driversRepository;
    }

    public PricesRepository getPricesRepository() {
        return pricesRepository;
    }
    
}

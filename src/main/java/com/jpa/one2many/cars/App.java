package com.jpa.one2many.cars;

import com.jpa.one2many.cars.entity.Car;
import com.jpa.one2many.cars.entity.Driver;
import com.jpa.one2many.cars.entity.Price;
import com.jpa.one2many.cars.service.CarsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    static CarsService service;

    static {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.jpa");
        appContext.refresh();
        service = (CarsService) appContext.getBean("carsService");
    }

    public static void main(String[] args) throws Exception {
        save();
    }
    
    public static void save() {
        Driver driver = new Driver("Mary");
        service.getDriversRepository().save(driver);
        
        Car c1 = new Car("Benz", new Price(200), driver);
        Car c2 = new Car("BMW", new Price(180), driver);
        service.getCarsRepository().save(c1);
        service.getCarsRepository().save(c2);
        
    }
    
    
    
}

package com.jpa.all.company.dao;

import com.jpa.all.company.entity.Salary;
import org.springframework.data.repository.CrudRepository;

public interface SalariesRepository extends CrudRepository<Salary, Integer>{
    
}

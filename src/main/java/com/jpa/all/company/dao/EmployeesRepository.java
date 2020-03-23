package com.jpa.all.company.dao;

import com.jpa.all.company.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeesRepository extends CrudRepository<Employee, Integer>{
    
}

package com.jpa.all.company.service;

import com.jpa.all.company.dao.ClubsRepository;
import com.jpa.all.company.dao.DepartmentsRepository;
import com.jpa.all.company.dao.EmployeesRepository;
import com.jpa.all.company.dao.SalariesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("companyService")
public class CompanyService {
    
    @Autowired
    private ClubsRepository clubsRepository;
    
    @Autowired
    private DepartmentsRepository departmentsRepository;
    
    @Autowired
    private EmployeesRepository employeesRepository;
    
    @Autowired
    private SalariesRepository salariesRepository;

    public ClubsRepository getClubsRepository() {
        return clubsRepository;
    }

    public DepartmentsRepository getDepartmentsRepository() {
        return departmentsRepository;
    }

    public EmployeesRepository getEmployeesRepository() {
        return employeesRepository;
    }

    public SalariesRepository getSalariesRepository() {
        return salariesRepository;
    }
    
    
    
    
}

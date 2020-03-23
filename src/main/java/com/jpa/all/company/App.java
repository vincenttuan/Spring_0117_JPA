package com.jpa.all.company;

import com.jpa.all.company.entity.Club;
import com.jpa.all.company.entity.Department;
import com.jpa.all.company.entity.Employee;
import com.jpa.all.company.entity.Salary;
import com.jpa.all.company.service.CompanyService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    static CompanyService service;

    static {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.jpa");
        appContext.refresh();
        service = (CompanyService) appContext.getBean("companyService");
    }

    public static void main(String[] args) throws Exception {
        joinClub();
    }

    public static void saveDepartment() {
        Department dep1 = new Department("IT");
        Department dep2 = new Department("Sales");
        service.getDepartmentsRepository().save(dep1);
        service.getDepartmentsRepository().save(dep2);
    }

    public static void saveEmployee() {

        Employee emp1 = new Employee("Vincent", new Salary(50000), service.getDepartmentsRepository().findById(1).get());
        Employee emp2 = new Employee("Anita", new Salary(40000), service.getDepartmentsRepository().findById(2).get());
        Employee emp3 = new Employee("Howard", new Salary(30000), service.getDepartmentsRepository().findById(2).get());
        Employee emp4 = new Employee("Joanna", new Salary(20000), service.getDepartmentsRepository().findById(1).get());
        service.getEmployeesRepository().save(emp1);
        service.getEmployeesRepository().save(emp2);
        service.getEmployeesRepository().save(emp3);
        service.getEmployeesRepository().save(emp4);

    }

    public static void saveClub() {
        Club c1 = new Club("A");
        Club c2 = new Club("B");
        service.getClubsRepository().save(c1);
        service.getClubsRepository().save(c2);

    }

    public static void joinClub() {
        Club club = service.getClubsRepository().findById(1).get();
        Employee employee = service.getEmployeesRepository().findById(1).get();
        club.getEmployees().add(employee);
        service.getClubsRepository().save(club);
    }
}

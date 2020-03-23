package com.jpa.all.company;

import com.jpa.all.company.entity.Club;
import com.jpa.all.company.entity.Department;
import com.jpa.all.company.entity.Employee;
import com.jpa.all.company.entity.Salary;
import com.jpa.all.company.service.CompanyService;
import java.util.List;
import java.util.Scanner;
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
        menu();
    }
    
    public static void menu() {
        System.out.println("---------------------------");
        System.out.println("1. 建立部門 Department");
        System.out.println("2. 建立社團 Club");
        System.out.println("3. 建立員工 Employee");
        System.out.println("4. 加入社團 Join club");
        System.out.println("5. 退出社團 Remove club");
        System.out.println("9. 查詢全部");
        System.out.println("0. Exit");
        System.out.println("請選擇: ");
        System.out.println("---------------------------");
        Scanner sc = new Scanner(System.in);
        switch(sc.nextInt()) {
            case 1:
                System.out.println("請輸入部門名稱: ");
                String deptName = sc.next();
                service.getDepartmentsRepository().save(new Department(deptName));
                break;
            case 2:
                System.out.println("請輸入Club名稱: ");
                String clubName = sc.next();
                service.getClubsRepository().save(new Club(clubName));
                break;
            case 3:
                System.out.println("請輸入員工姓名: ");
                String empName = sc.next();
                
                System.out.println("請輸入員工薪水: ");
                int money = sc.nextInt();
                
                System.out.println("請輸入所屬部門 id: ");
                int depId = sc.nextInt();
                
                Salary salary = new Salary(money);
                Department department = service.getDepartmentsRepository().findById(depId).get();
                service.getEmployeesRepository().save(new Employee(empName, salary, department));
                break;
            case 4:
                System.out.println("請輸入員工 id: ");
                int empId = sc.nextInt();
                
                System.out.println("請輸入社團 id: ");
                int clubId = sc.nextInt();
                
                Employee employee = service.getEmployeesRepository().findById(empId).get();
                Club club = service.getClubsRepository().findById(clubId).get();
                employee.getClubs().add(club);
                service.getEmployeesRepository().save(employee);
            case 5:
                System.out.println("請輸入員工 id: ");
                int e_id = sc.nextInt();
                System.out.println("請輸入欲退出社團 id: ");
                int c_id = sc.nextInt();
                service.getEmployeesRepository().removeClub(e_id, c_id);
                break;
            case 9:
                System.out.println(service.getDepartmentsRepository().findAll());
                System.out.println(service.getClubsRepository().findAll());
                System.out.println(service.getEmployeesRepository().findAll());
                break;
            case 0:
                return;
        }
        menu();
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
        Club club = service.getClubsRepository().findById(2).get();
        Employee employee = service.getEmployeesRepository().findById(3).get();
        employee.getClubs().add(club);
        service.getEmployeesRepository().save(employee);
    }
}

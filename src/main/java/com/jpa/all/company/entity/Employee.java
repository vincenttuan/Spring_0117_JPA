package com.jpa.all.company.entity;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column
    private String name;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salary_id")
    private Salary salary;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false) // optional = false (inner join), optional = true (left join) 預設
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;
    
    @ManyToMany()
    @JoinTable(name = "employee_club", 
            joinColumns = {
                @JoinColumn(name = "employee_id", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                @JoinColumn(name = "club_id", nullable = false, updatable = false)
            }
    )
    private Set<Club> clubs = new LinkedHashSet<>();
    
    public Employee() {
    }

    public Employee(String name, Salary salary, Department department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
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

    public Set<Club> getClubs() {
        return clubs;
    }
    
    
}

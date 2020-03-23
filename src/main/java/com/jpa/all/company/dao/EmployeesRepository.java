package com.jpa.all.company.dao;

import com.jpa.all.company.entity.Employee;
import java.util.Set;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface EmployeesRepository extends CrudRepository<Employee, Integer>{
    @Transactional
    @Modifying
    //@Query(value = "DELETE FROM fund_stock WHERE fund_id=? AND stock_id=?", nativeQuery = true)
    @Query(value = "DELETE FROM employee_club WHERE employee_id=?1 AND club_id=?2", nativeQuery = true)
    public void removeClub(int employee_id, int club_id);
    
    //@Query(value = "SELECT * FROM employees", nativeQuery = true)
    //public Set<Employee> queryAll();
    
}

package com.restapi.employeemicroservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Following is native query or name query, only for Max salary employee
    @Query(value = "select * from employee where emp_salary = (select Max(emp_salary) from employee)",nativeQuery = true)
    public List<Employee> getHighestSalaryEmployee();

    // Following is native query or name query, only for salary greater than

    @Query(value = "select * from employee where emp_salary > 40000)",nativeQuery = true)
    public List<Employee> findEmployeeSalaryGreaterThan();
}

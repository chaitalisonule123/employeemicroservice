package com.restapi.employeemicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
@Component
public class CacheManager {

    @Autowired
    EmployeeRepository employeeRepository;
    public static HashMap<Integer, Employee> cache = new HashMap<>();

    @Scheduled(cron = "* * * * * *")
    public void loadData() {
        System.out.println("Cache loading started . . .");
        List<Employee> employeeList = employeeRepository.findAll();
        employeeList.forEach(employee -> cache.put(employee.getEmpId(),employee));
        System.out.println("Cache loading ended . . .");
    }
}

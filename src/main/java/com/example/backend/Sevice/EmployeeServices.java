package com.example.backend.Sevice;

import com.example.backend.Entity.Employee;
import com.example.backend.Repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServices {
    private final EmployeeRepository employeeRepository;

    @Autowired

    public EmployeeServices(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Map<String, Object>> getSupervisorHierarchy(String name) {
        return employeeRepository.findSupervisorHierarchy(name);
    }

    public List<Employee> getAllEmployees(){
        return this.employeeRepository.findAll();
    }
}

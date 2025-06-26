package com.example.backend.Controller;

import com.example.backend.Entity.Employee;
import com.example.backend.Sevice.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "https://front-workflow-gzq3.vercel.app/")
@RequestMapping(value ="/api/employee")
public class EmployeeController {

    private final EmployeeServices employeeService;

    @Autowired
    public EmployeeController(EmployeeServices employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/workflow/{name}")
    public List<Map<String, Object>> getSupervisorHierarchy(@PathVariable String name) {
        return employeeService.getSupervisorHierarchy(name);
    }

    @GetMapping("")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
}



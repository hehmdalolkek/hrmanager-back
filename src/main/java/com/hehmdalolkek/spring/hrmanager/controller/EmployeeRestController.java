package com.hehmdalolkek.spring.hrmanager.controller;

import com.hehmdalolkek.spring.hrmanager.entity.Employee;
import com.hehmdalolkek.spring.hrmanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://hrmanager-front.onrender.com", value = "http://localhost:3000")
@RequestMapping("/api")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {

        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee showEmployeeById(@PathVariable("id") int id) {

        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employees")
    public void addEmployee(@RequestBody Employee employee) {

        employeeService.addEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public void updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {

        employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable("id") int id) {

        employeeService.deleteEmployeeById(id);
    }

    @GetMapping("/employees/department/{id}")
    public List<Employee> showEmployeesByDepartment(@PathVariable("id") int id) {

        return employeeService.getEmployeesByDepartment(id);
    }

}

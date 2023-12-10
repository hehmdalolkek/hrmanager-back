package com.hehmdalolkek.spring.hrmanager.service;

import com.hehmdalolkek.spring.hrmanager.entity.Employee;
import jakarta.validation.Valid;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(int id);

    public void addEmployee(@Valid Employee employee);

    public void updateEmployee(int id, @Valid Employee employee);

    public void deleteEmployeeById(int id);

    public List<Employee> getEmployeesByDepartment(int id);

}

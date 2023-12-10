package com.hehmdalolkek.spring.hrmanager.service;

import com.hehmdalolkek.spring.hrmanager.dao.DepartmentRepository;
import com.hehmdalolkek.spring.hrmanager.dao.EmployeeRepository;
import com.hehmdalolkek.spring.hrmanager.entity.Department;
import com.hehmdalolkek.spring.hrmanager.entity.Employee;
import com.hehmdalolkek.spring.hrmanager.exceptions.DepartmentNotFoundException;
import com.hehmdalolkek.spring.hrmanager.exceptions.EmployeeNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;


@Service
@Validated
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {

        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @Override
    @Transactional
    public void addEmployee(@Valid Employee employee) {
        Department department = departmentRepository.findById(employee.getDepartment().getId())
                .orElseThrow(() -> new DepartmentNotFoundException(0));

        employee.setDepartment(department);
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void updateEmployee(int id, @Valid Employee employee) {

        employeeRepository.findById(id)
                .map(emp -> {
                    emp.setName(employee.getName());
                    emp.setSurname(employee.getSurname());
                    emp.setAge(employee.getAge());
                    emp.setPhone(employee.getPhone());
                    emp.setExperience(employee.getExperience());
                    emp.setDepartment(employee.getDepartment());
                    emp.setSalary(employee.getSalary());
                    return employeeRepository.save(emp);
                }).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @Override
    @Transactional
    public void deleteEmployeeById(int id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException(id);
        }

        employeeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<Employee> getEmployeesByDepartment(int id) {
        if (!departmentRepository.existsById(id)) {
            throw new DepartmentNotFoundException(id);
        }

        return employeeRepository.findAllByDepartmentId(id);
    }
}

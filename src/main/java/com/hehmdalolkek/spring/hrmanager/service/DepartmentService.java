package com.hehmdalolkek.spring.hrmanager.service;

import com.hehmdalolkek.spring.hrmanager.entity.Department;
import jakarta.validation.Valid;

import java.util.List;

public interface DepartmentService {

    public Department getDepartmentById(int id);

    public List<Department> getAllDepartments();

    public void addDepartment(@Valid Department department);

    public void updateDepartment(int id, @Valid Department department);

    public void deleteDepartmentById(int id);

}

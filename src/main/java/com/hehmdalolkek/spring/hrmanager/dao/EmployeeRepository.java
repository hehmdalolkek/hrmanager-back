package com.hehmdalolkek.spring.hrmanager.dao;

import com.hehmdalolkek.spring.hrmanager.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public List<Employee> findAllByDepartmentId(int id);
}

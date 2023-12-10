package com.hehmdalolkek.spring.hrmanager.dao;

import com.hehmdalolkek.spring.hrmanager.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}

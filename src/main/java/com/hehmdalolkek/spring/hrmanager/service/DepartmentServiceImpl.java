package com.hehmdalolkek.spring.hrmanager.service;

import com.hehmdalolkek.spring.hrmanager.dao.DepartmentRepository;
import com.hehmdalolkek.spring.hrmanager.entity.Department;
import com.hehmdalolkek.spring.hrmanager.exceptions.DepartmentNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public Department getDepartmentById(int id) {

        return departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException(id));
    }

    @Override
    @Transactional
    public List<Department> getAllDepartments() {

        return departmentRepository.findAll();
    }

    @Override
    @Transactional
    public void addDepartment(@Valid Department department) {

        departmentRepository.save(department);
    }

    @Override
    @Transactional
    public void updateDepartment(int id, @Valid Department department) {

        Department dep = departmentRepository.findById(id).orElse(null);

        if (dep == null) {
            throw new DepartmentNotFoundException(id);
        }

        dep.setTitle(department.getTitle());
        dep.setDescription(department.getDescription());
        departmentRepository.save(dep);
    }

    @Override
    @Transactional
    public void deleteDepartmentById(int id) {
        if (!departmentRepository.existsById(id)) {
            throw new DepartmentNotFoundException(id);
        }

        departmentRepository.deleteById(id);
    }
}

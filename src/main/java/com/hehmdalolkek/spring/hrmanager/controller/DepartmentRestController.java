package com.hehmdalolkek.spring.hrmanager.controller;

import com.hehmdalolkek.spring.hrmanager.entity.Department;
import com.hehmdalolkek.spring.hrmanager.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
public class DepartmentRestController {

    @Autowired
    private DepartmentService departmentService;


    @GetMapping("/departments/{id}")
    public Department showDepartmentById(@PathVariable("id") int id) {

        return departmentService.getDepartmentById(id);
    }

    @GetMapping("/departments")
    public List<Department> showAllDepartments() {

        return departmentService.getAllDepartments();
    }

    @PostMapping("/departments")
    public void addDepartment(@RequestBody Department department) {

        departmentService.addDepartment(department);
    }

    @PutMapping("/departments/{id}")
    public void updateDepartment(@PathVariable("id") int id, @RequestBody Department department) {

        departmentService.updateDepartment(id, department);
    }

    @DeleteMapping("/departments/{id}")
    public void deleteDepartmentById(@PathVariable("id") int id) {

        departmentService.deleteDepartmentById(id);
    }
}

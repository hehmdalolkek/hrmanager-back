package com.hehmdalolkek.spring.hrmanager.exceptions;

public class DepartmentNotFoundException extends RuntimeException{
    public DepartmentNotFoundException(int id){
        super("Could not found the department with id "+ id);
    }
}

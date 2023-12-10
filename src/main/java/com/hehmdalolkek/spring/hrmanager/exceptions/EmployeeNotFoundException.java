package com.hehmdalolkek.spring.hrmanager.exceptions;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(int id){
        super("Could not found the employee with id "+ id);
    }
}

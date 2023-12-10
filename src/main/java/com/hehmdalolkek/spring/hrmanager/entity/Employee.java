package com.hehmdalolkek.spring.hrmanager.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank
    @Size(min = 2, max = 32)
    @Column(name = "name")
    private String name;

    @NotBlank
    @Size(min = 2, max = 32)
    @Column(name = "surname")
    private String surname;

    @Min(value = 18)
    @Max(value = 100)
    @Column(name = "age")
    private int age;

    @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")
    @Column(name = "phone")
    private String phone;

    @Min(value = 0)
    @Max(value = 100)
    @Column(name = "experience")
    private int experience;

    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;

    @Min(value = 0)
    @Column(name = "salary")
    private double salary;

    public Employee() {
    }

    public Employee(String name, String surname, int age, String phone, int experience, Department department, double salary) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone = phone;
        this.experience = experience;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", experience=" + experience +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
}

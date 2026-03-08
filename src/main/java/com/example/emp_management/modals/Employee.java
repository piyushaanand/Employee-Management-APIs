package com.example.emp_management.modals;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name should'nt be null")
    @Size(min = 3, max = 40, message = "Name must contain character between 3 to 40")
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String dept;

    @Min(value = 10000, message = "Salary must not be negative")
    private double salary;

    @NotBlank
    private String designation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Employee(Long id, String name, String email, String dept, double salary, String designation) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dept = dept;
        this.salary = salary;
        this.designation = designation;
    }

    public Employee() {
    }

    

    
}

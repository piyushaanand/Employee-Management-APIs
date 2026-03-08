package com.example.emp_management.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.emp_management.exceptions.DeleteException;
import com.example.emp_management.exceptions.GetException;
import com.example.emp_management.exceptions.PostException;
import com.example.emp_management.exceptions.PutException;
import com.example.emp_management.modals.Employee;
import com.example.emp_management.repos.EmpRepo;

@Service
public class EmpService {

    @Autowired
    EmpRepo empRepo;


    public Employee createEmployee(Employee employee){
        Optional<Employee> e = empRepo.findById(employee.getId());
        if(e.isPresent()){
            throw new PostException("Employee with id "+ employee.getId()+" Already present");
        }
        Employee emp = empRepo.save(employee);
        return emp;
    }

    public Page<Employee> getAllEmployee(Pageable pageable){
        Page<Employee> emp = empRepo.findAll(pageable);
        return emp;
        
    }

    public Employee getEmplById(Long id){

        Optional<Employee> e = empRepo.findById(id);
        if(e.isEmpty()){
            throw new GetException("Employee with id "+ id + " is not Present");
        }
        Employee emp = empRepo.findById(id).orElse(null);
        return emp;
    }


    public Employee updateEmployee(Long id, Employee empl){
        Optional<Employee> emp = empRepo.findById(id);
        if(emp.isEmpty()){
            throw new PutException("Employee with id "+ id + " is not Present to update");
        }
        if(emp.isPresent()){
            Employee existingEmployee = emp.get();
            existingEmployee.setName(empl.getName());
            existingEmployee.setEmail(empl.getEmail());
            existingEmployee.setDept(empl.getDept());
            existingEmployee.setSalary(empl.getSalary());
            existingEmployee.setDesignation(empl.getDesignation());

            return existingEmployee;
        }else{
            return null;
        }
    }

    public String DeleteById(Long id){
        Optional<Employee> emp = empRepo.findById(id);
        if(emp.isEmpty()){
            throw new DeleteException("Employee with id "+ id + " is not present to delete");
        }
        empRepo.deleteById(id);
        return "Employee Details Deleted Successfully";
    }
    
}

package com.example.emp_management.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
// import org.springframework.boot.data.autoconfigure.web.DataWebProperties.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.emp_management.modals.Employee;
import com.example.emp_management.services.EmpService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    EmpService empService;

    @PostMapping("/create")
    public ResponseEntity<?> createEmp(@RequestBody @Valid Employee employee){
        return ResponseEntity.ok(empService.createEmployee(employee));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllEmp(Pageable pageable){
        return ResponseEntity.ok(empService.getAllEmployee(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmpById(@PathVariable Long id){
        return ResponseEntity.ok(empService.getEmplById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployeeById(@PathVariable Long id, @RequestBody Employee employee){
        return ResponseEntity.ok(empService.updateEmployee(id, employee));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
        return ResponseEntity.ok(empService.DeleteById(id));
    }
    
}

package com.example.emp_management.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.emp_management.modals.Employee;


@Repository
public interface EmpRepo extends JpaRepository<Employee, Long>{
    
}

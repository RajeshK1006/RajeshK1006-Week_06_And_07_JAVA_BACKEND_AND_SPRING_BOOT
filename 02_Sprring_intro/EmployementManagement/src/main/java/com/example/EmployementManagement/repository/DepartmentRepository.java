package com.example.EmployementManagement.repository;

import com.example.EmployementManagement.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {}

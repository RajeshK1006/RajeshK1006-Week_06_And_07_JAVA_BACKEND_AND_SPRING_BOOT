package com.example.EmployementManagement.service;

import com.example.EmployementManagement.model.Department;
import com.example.EmployementManagement.model.Employee;
import com.example.EmployementManagement.repository.DepartmentRepository;
import com.example.EmployementManagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepo;
    private final DepartmentRepository departmentRepo;

    public EmployeeService(EmployeeRepository employeeRepo, DepartmentRepository departmentRepo) {
        this.employeeRepo = employeeRepo;
        this.departmentRepo = departmentRepo;
    }

    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }

    public Employee getById(Long id) {
        return employeeRepo.findById(id).orElseThrow();
    }

    public Employee create(Employee employee) {
        Department dept = departmentRepo.save(employee.getDepartment());
        employee.setDepartment(dept);
        return employeeRepo.save(employee);
    }

    public Employee update(Long id, Employee updated) {
        Employee existing = employeeRepo.findById(id).orElseThrow();
        existing.setName(updated.getName());
        Department dept = departmentRepo.save(updated.getDepartment());
        existing.setDepartment(dept);
        return employeeRepo.save(existing);
    }

    public void delete(Long id) {
        employeeRepo.deleteById(id);
    }
}
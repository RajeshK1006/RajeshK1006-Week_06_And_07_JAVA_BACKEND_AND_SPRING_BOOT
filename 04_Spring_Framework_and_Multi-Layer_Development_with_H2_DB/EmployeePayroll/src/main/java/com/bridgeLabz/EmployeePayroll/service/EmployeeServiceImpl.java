package com.bridgeLabz.EmployeePayroll.service;


import com.bridgeLabz.EmployeePayroll.repository.EmployeeRepository;
import com.bridgeLabz.EmployeePayroll.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl  implements  EmployeeService{


    private final EmployeeRepository ep;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository ep){
        this.ep = ep;
    }


    @Override
    public List<Employee> getAllEmployees() {
        return ep.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return ep.findById(id).orElseThrow(() -> new RuntimeException("No employee found with that id"));
    }

    @Override
    public Employee createEmployee(Employee emp) {
        return ep.save(emp);
    }

    @Override
    public Employee updateEmployee(Long id, Employee emp) {
        return ep.findById(id).map(empl -> {
            empl.setName(emp.getName());
            empl.setEmail(emp.getEmail());
            empl.setSalary(emp.getSalary());

            return ep.save(empl);
        }).orElseThrow(() -> new RuntimeException("Employee not found with the id: " +id));
    }

    @Override
    public void deleteEmployee(Long id) {
        if (!ep.existsById(id)) {
            throw new RuntimeException("Employee not found with ID: " + id);
        }
        ep.deleteById(id);
    }
}

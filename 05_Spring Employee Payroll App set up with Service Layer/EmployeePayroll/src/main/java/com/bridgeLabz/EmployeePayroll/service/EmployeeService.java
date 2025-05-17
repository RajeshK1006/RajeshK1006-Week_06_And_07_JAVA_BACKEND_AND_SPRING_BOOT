package com.bridgeLabz.EmployeePayroll.service;


import com.bridgeLabz.EmployeePayroll.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee createEmployee(Employee emp);
    Employee updateEmployee(Long id, Employee emp);
    void deleteEmployee(Long id);

}
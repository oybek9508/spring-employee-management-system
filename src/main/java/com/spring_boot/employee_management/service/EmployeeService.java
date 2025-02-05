package com.spring_boot.employee_management.service;

import com.spring_boot.employee_management.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    Employee addEmployee(Employee employee);

    Employee updateEmployee(Employee employee, Long id);

    void deleteEmployee(Long id);
}

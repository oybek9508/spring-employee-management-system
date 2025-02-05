package com.spring_boot.employee_management.service;

import com.spring_boot.employee_management.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();

    Department getDepartmentById(Long id);

    Department addDepartment(Department department);

    Department updateDepartment(Department department, Long id);

    void deleteDepartment(Long id);
}

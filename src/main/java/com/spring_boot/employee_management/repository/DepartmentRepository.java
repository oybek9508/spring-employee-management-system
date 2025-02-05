package com.spring_boot.employee_management.repository;

import com.spring_boot.employee_management.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}

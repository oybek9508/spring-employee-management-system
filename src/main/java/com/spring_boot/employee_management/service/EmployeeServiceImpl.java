package com.spring_boot.employee_management.service;

import com.spring_boot.employee_management.entity.Employee;
import com.spring_boot.employee_management.repository.DepartmentRepository;
import com.spring_boot.employee_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final DepartmentRepository departmentRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = theEmployeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("The employee with id " + id + " does not exist"));
    }

    @Override
    public Employee addEmployee(Employee employee) {
//        Department department = departmentRepository.findById(employee.getDepartment().getId()).orElseThrow(() -> new RuntimeException("The department with id " + employee.getDepartment().getId() + " does not exist"));
//        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        Employee existingEmployee = getEmployeeById(id);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setAge(employee.getAge());

        if (employee.getDepartment() != null) {
            existingEmployee.setDepartment(employee.getDepartment());
        }

        return employeeRepository.save(existingEmployee);
    }


    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}

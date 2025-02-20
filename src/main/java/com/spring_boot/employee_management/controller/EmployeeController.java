package com.spring_boot.employee_management.controller;

import com.spring_boot.employee_management.entity.Employee;
import com.spring_boot.employee_management.entity.Leave;
import com.spring_boot.employee_management.enums.LeaveEnum;
import com.spring_boot.employee_management.service.EmployeeService;
import com.spring_boot.employee_management.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final LeaveService leaveService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, LeaveService leaveService) {
        this.employeeService = employeeService;
        this.leaveService = leaveService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
        return employeeService.updateEmployee(employee, id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @PostMapping("/{id}/leave/{leaveType}")
    public ResponseEntity<Leave> assignLeaveToEmployee(@PathVariable Long id, @PathVariable LeaveEnum leaveType) {
        Leave assignLeave = leaveService.assignLeaveToEmployee(leaveType, id);
        return ResponseEntity.ok(assignLeave);
    }

}

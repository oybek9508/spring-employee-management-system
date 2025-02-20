package com.spring_boot.employee_management.service;

import com.spring_boot.employee_management.entity.Employee;
import com.spring_boot.employee_management.entity.Leave;
import com.spring_boot.employee_management.enums.LeaveEnum;
import com.spring_boot.employee_management.repository.EmployeeRepository;
import com.spring_boot.employee_management.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LeaveServiceImpl implements LeaveService {
    private final LeaveRepository leaveRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public LeaveServiceImpl(LeaveRepository leaveRepository, EmployeeRepository employeeRepository) {
        this.leaveRepository = leaveRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Leave assignLeaveToEmployee(LeaveEnum leaveType, Long employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);

        if (!optionalEmployee.isPresent()) {
            throw new RuntimeException("Employee not found");
        }

        Employee employee = optionalEmployee.get();

        if (employee.getLeave() != null) {
            throw new RuntimeException("Leave already assigned to the employee");
        }

        Optional<Leave> optionalLeave = leaveRepository.findByName(leaveType);
        if (optionalLeave.isEmpty()) {
            throw new RuntimeException("Leave not found");
        }

        Leave leave = optionalLeave.get();
        employee.setLeave(leave);
        employeeRepository.save(employee);

        return leave;
    }

}

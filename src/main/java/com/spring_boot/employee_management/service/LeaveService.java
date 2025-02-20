package com.spring_boot.employee_management.service;

import com.spring_boot.employee_management.entity.Leave;
import com.spring_boot.employee_management.enums.LeaveEnum;

public interface LeaveService {

    Leave assignLeaveToEmployee(LeaveEnum leaveType, Long employeeId);

//    Leave getLeaveById(Integer id);
//
//    Leave updateLeave(Leave leave);
//
//    void deleteLeave(Integer id);
}

package com.spring_boot.employee_management.service;

import com.spring_boot.employee_management.dtos.RegisterUserDto;
import com.spring_boot.employee_management.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<User> getAuthenticatedUser();

    List<User> getAllUsers();

    User createAdministrator(RegisterUserDto input);
}

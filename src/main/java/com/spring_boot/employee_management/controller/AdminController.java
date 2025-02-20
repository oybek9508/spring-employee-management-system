package com.spring_boot.employee_management.controller;

import com.spring_boot.employee_management.dtos.RegisterUserDto;
import com.spring_boot.employee_management.entity.User;
import com.spring_boot.employee_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admins")
public class AdminController {
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<User> createAdmin(@RequestBody RegisterUserDto dto) {
        User createAdmin = userService.createAdministrator(dto);
        return ResponseEntity.ok(createAdmin);
    }
}

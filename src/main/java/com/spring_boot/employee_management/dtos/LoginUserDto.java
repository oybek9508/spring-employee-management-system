package com.spring_boot.employee_management.dtos;

import lombok.Data;

@Data
public class LoginUserDto {
    private String email;
    private String password;
}

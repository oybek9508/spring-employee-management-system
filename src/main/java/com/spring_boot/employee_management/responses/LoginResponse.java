package com.spring_boot.employee_management.responses;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private Long expiresIn;
}

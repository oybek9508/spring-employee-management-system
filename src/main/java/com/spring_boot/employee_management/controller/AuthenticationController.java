package com.spring_boot.employee_management.controller;

import com.spring_boot.employee_management.dtos.LoginUserDto;
import com.spring_boot.employee_management.dtos.RegisterUserDto;
import com.spring_boot.employee_management.entity.User;
import com.spring_boot.employee_management.responses.LoginResponse;
import com.spring_boot.employee_management.service.AuthenticationService;
import com.spring_boot.employee_management.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService theAuthenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = theAuthenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody RegisterUserDto dto) {
        User registeredUser = authenticationService.signup(dto);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginUserDto dto) {
        // first authenticate user
        User authenticatedUser = authenticationService.authenticate(dto);

        // if authentication is successful, then generate token
        String jwtToken = jwtService.generateToken(authenticatedUser);

        // set login response with proper attributes and values;
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}

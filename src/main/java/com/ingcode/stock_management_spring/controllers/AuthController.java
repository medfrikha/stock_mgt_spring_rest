package com.ingcode.stock_management_spring.controllers;

import com.ingcode.stock_management_spring.dto.LogInRequest;
import com.ingcode.stock_management_spring.dto.LogInResponse;
import com.ingcode.stock_management_spring.dto.SignUpRequest;
import com.ingcode.stock_management_spring.dto.SignUpResponse;
import com.ingcode.stock_management_spring.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public LogInResponse login(@RequestBody LogInRequest request) {
        return authService.login(request);
    }

    @PostMapping("/register")
    public SignUpResponse register(@RequestBody SignUpRequest request) {
        return authService.register(request);
    }
}

package com.ingcode.stock_management_spring.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponse {
    // getters & setters
    private String message;
    @Email
    private String email;
    private String role;

    public SignUpResponse() {}

    public SignUpResponse(String message, String email, String role) {
        this.message = message;
        this.email = email;
        this.role = role;
    }
}

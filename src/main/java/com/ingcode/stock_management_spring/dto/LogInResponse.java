package com.ingcode.stock_management_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LogInResponse {
    private String token;
    private UserResponse user;

}

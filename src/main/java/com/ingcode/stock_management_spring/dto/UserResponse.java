package com.ingcode.stock_management_spring.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private Long id;
    private String userName;
    private String email;
}
package com.ingcode.stock_management_spring.services;

import com.ingcode.stock_management_spring.dto.*;
import org.springframework.transaction.annotation.Transactional;

public interface AuthService {
    public SignUpResponse register(SignUpRequest signUpRequest);
    public LogInResponse login(LogInRequest signInRequest);

}

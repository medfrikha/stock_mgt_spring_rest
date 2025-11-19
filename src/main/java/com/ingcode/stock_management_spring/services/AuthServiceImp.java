package com.ingcode.stock_management_spring.services;

import com.ingcode.stock_management_spring.dto.*;
import com.ingcode.stock_management_spring.entities.Role;
import com.ingcode.stock_management_spring.entities.User;
import com.ingcode.stock_management_spring.repositories.RoleRepository;
import com.ingcode.stock_management_spring.repositories.UserRepository;
import com.ingcode.stock_management_spring.security.jwt.JwtService;
import com.ingcode.stock_management_spring.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ingcode.stock_management_spring.entities.ERole.USER;

@Service
public class AuthServiceImp implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Override
    public LogInResponse login(LogInRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail()) // email as username
                .password(user.getPassword())
                .roles(user.getRole().stream()
                        .map(r -> r.getName().name()) // convert ERole enum to String
                        .toArray(String[]::new))
                .build();
        String jwt = jwtService.generateToken(userDetails);

        return new LogInResponse(jwt, UserResponse.builder()
                .id(user.getId())
                .userName(user.getUsername())
                .email(user.getEmail())
                .build());
    }

    @Override
    public SignUpResponse register(SignUpRequest signUpRequest){

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new RuntimeException("Email already taken");
        }

        User user = new User();
        user.setUserName(signUpRequest.getUserName());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        Role userRole = roleRepository.findByName(USER)
                .orElseThrow(() -> new RuntimeException("Default role USER not found"));

        user.getRole().add(userRole);

        userRepository.save(user);
        // Convert roles to a readable format
        List<String> roles = user.getRole().stream()
                .map(role -> role.getName().name()) // convert Enum to String
                .toList();
        return new SignUpResponse(
                "User registered successfully",
                user.getEmail(),
                 "USER"
                 // Assuming default role is USER, adjust as needed
        );
    }
}
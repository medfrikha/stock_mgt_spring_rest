package com.ingcode.stock_management_spring.security;

import com.ingcode.stock_management_spring.entities.User;
import com.ingcode.stock_management_spring.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    private final UserRepository userRepository;
    
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())  // or user.getUsername() depending on your User entity
                .password(user.getPassword())
                .roles(user.getRole().stream()
                        .map(role -> role.getName().name()) // convert ERole enum to String
                        .toArray(String[]::new))
                .build();
    }
}

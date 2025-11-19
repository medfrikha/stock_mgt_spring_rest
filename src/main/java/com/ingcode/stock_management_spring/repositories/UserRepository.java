package com.ingcode.stock_management_spring.repositories;

import com.ingcode.stock_management_spring.entities.ERole;
import com.ingcode.stock_management_spring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUserName(String userName);
    Optional<User> findByRole(ERole role);
    List<User> findAll();
    boolean existsByEmail(String email);

    @Override
    <S extends User> S save(S entity);
}

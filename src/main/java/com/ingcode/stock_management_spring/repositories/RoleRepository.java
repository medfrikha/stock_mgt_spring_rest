package com.ingcode.stock_management_spring.repositories;

import com.ingcode.stock_management_spring.entities.ERole;
import com.ingcode.stock_management_spring.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);
    List<Role> findAll();
    boolean existsByName(ERole name);

}

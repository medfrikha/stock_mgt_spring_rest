package com.ingcode.stock_management_spring.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @NotEmpty
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    public void setName(ERole name) {
        this.name = name;
    }

    public ERole getName() {
        return name;
    }
}

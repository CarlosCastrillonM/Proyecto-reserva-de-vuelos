package com.example.eldorado.repository;

import com.example.eldorado.entity.ERole;
import com.example.eldorado.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}

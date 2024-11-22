package com.cpiura.catics.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpiura.catics.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username); // Buscar por username

    Optional<User> findByUsernameOrId(String username, Long id); // Buscar por username o id

    Optional<User> findByEmail(String email); // Buscar por email

    Optional<User> findByUsernameOrEmail(String username, String email);
}

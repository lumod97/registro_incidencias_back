package com.cpiura.catics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpiura.catics.entity.GlpiUsers;

@Repository
public interface GlpiUserRepository extends JpaRepository<GlpiUsers, Integer> {
    // Puedes agregar métodos de consulta personalizados aquí
}

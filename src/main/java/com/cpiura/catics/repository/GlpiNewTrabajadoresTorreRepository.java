package com.cpiura.catics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpiura.catics.entity.GlpiNewTrabajadoresTorre;

@Repository
public interface GlpiNewTrabajadoresTorreRepository extends JpaRepository<GlpiNewTrabajadoresTorre, Integer> {
    // Métodos personalizados si es necesario
}

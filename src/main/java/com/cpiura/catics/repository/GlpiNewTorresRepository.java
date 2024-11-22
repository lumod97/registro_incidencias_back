package com.cpiura.catics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpiura.catics.entity.GlpiNewTorres;

@Repository
public interface GlpiNewTorresRepository extends JpaRepository<GlpiNewTorres, Integer> {
    // Métodos personalizados si es necesario
}

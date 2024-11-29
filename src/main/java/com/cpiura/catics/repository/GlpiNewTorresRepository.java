package com.cpiura.catics.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpiura.catics.entity.GlpiNewTorres;

@Repository
public interface GlpiNewTorresRepository extends JpaRepository<GlpiNewTorres, Integer> {

    Optional<GlpiNewTorres> findById(Long id);
    // Métodos personalizados si es necesario

    void deleteById(Long id);
}

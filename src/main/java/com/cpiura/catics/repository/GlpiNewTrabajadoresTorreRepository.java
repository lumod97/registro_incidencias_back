package com.cpiura.catics.repository;

import com.cpiura.catics.entity.GlpiNewTrabajadoresTorre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GlpiNewTrabajadoresTorreRepository extends JpaRepository<GlpiNewTrabajadoresTorre, Long> {
    // Puedes agregar métodos personalizados si lo necesitas
}

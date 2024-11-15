package com.cpiura.catics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cpiura.catics.entity.Metas;

@Repository
public interface MetasRepository extends JpaRepository<Metas, Integer> {
    List<Metas> findByOrderByPeriodoDesc();

    // Consulta personalizada con @Query
    @Query("SELECT m FROM Metas m WHERE " +
    "(:periodo IS NULL OR :periodo = '' OR m.periodo = :periodo) " +
    "AND (:userId IS NULL OR :userId = '' OR m.userId = :userId)")
List<Metas> findByPeriodoOrUserId(@Param("periodo") String periodo, @Param("userId") String userId);

// Consulta personalizada con @Query usando SQL nativo
@Query(value = "SELECT m.id AS idMeta, m.periodo, m.meta, u.name " +
"FROM glpi_metas m " +
"INNER JOIN glpi_users u ON u.id = m.user_id " +
"WHERE (:periodo IS NULL OR :periodo = '' OR m.periodo = :periodo) " +
"AND (:userId IS NULL OR :userId = '' OR u.id = :userId)", nativeQuery = true)
List<Object[]> findMetasFiltered(@Param("periodo") String periodo, @Param("userId") String userId);


}

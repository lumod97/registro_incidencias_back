package com.cpiura.catics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpiura.catics.entity.ItilCategory;

@Repository
public interface ItilCategoryRepository extends JpaRepository<ItilCategory, Integer> {
    List<ItilCategory> findTop10ByOrderByIdDesc(); // If you want to order by the 'date' field
}

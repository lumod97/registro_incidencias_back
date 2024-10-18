package com.cpiura.catics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpiura.catics.entity.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
    List<Group> findTop10ByOrderByIdDesc(); // If you want to order by the 'date' field
}

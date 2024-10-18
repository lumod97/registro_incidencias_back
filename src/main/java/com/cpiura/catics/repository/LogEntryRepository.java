package com.cpiura.catics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpiura.catics.entity.LogEntry;

@Repository
public interface LogEntryRepository extends JpaRepository<LogEntry, Integer> {
    List<LogEntry> findTop10ByOrderByIdDesc(); // If you want to order by the 'date' field
}

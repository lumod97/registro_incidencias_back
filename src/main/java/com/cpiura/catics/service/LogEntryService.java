package com.cpiura.catics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpiura.catics.entity.LogEntry;
import com.cpiura.catics.repository.LogEntryRepository;

@Service
public class LogEntryService {
    @Autowired
    private LogEntryRepository logEntryRepository;

    public List<LogEntry> getTop10Tickets() {
        return logEntryRepository.findTop10ByOrderByIdDesc(); // Llama al método del repositorio
    }
}

package com.cpiura.catics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpiura.catics.entity.LogEntry;
import com.cpiura.catics.service.LogEntryService;

@RestController

public class LogEntryController {
    @Autowired
    private LogEntryService logEntryService;

    @GetMapping("/log_entry/top10")
    public List<LogEntry> getTop10Tickets() {
        return logEntryService.getTop10Tickets(); // Calls the service to get the tickets
    }
}

package com.cpiura.catics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpiura.catics.entity.ReporteTickets;
import com.cpiura.catics.entity.TicketsPriorityStats;
import com.cpiura.catics.service.ReporteTicketsService;

@RestController
// @RequestMapping("/api/reporte-tickets")
public class ReporteTicketController {

    @Autowired
    private ReporteTicketsService reporteTicketsService;

    @GetMapping("/api/reporte-tickets")
    public List<ReporteTickets> getTickets() {
        return reporteTicketsService.getTicketsReport();
    }
    
    @GetMapping("/api/reporte-tickets-statistics")
    public TicketsPriorityStats getTicketsStatistics() {
        return reporteTicketsService.getTicketsPriorityStatistics();
    }

    @GetMapping("/api/reporte-tickets-info")
    public String getReporteTickets() {
        return reporteTicketsService.getColumnInfoFromSP();
    }
}

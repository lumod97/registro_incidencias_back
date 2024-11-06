package com.cpiura.catics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cpiura.catics.Request.ReportPerPersonRequest;
import com.cpiura.catics.Request.TicketStatisticksPerMonthRequest;
import com.cpiura.catics.entity.ReportPerPerson;
import com.cpiura.catics.entity.ReporteTickets;
import com.cpiura.catics.entity.TicketsPriorityStats;
import com.cpiura.catics.entity.TicketsStatusStats;
import com.cpiura.catics.service.ReporteTicketsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ReporteTicketController {

    @Autowired
    private ReporteTicketsService reporteTicketsService;

    @GetMapping("/tickets/reporte-tickets")
    public List<ReporteTickets> getTickets() {
        return reporteTicketsService.getTicketsReport();
    }

    @GetMapping("/tickets/reporte-tickets-statistics")
    public TicketsPriorityStats getTicketsStatistics() {
        return reporteTicketsService.getTicketsPriorityStatistics();
    }

    @PostMapping("/tickets/get-ticket-statistics-per-month")
    public TicketsPriorityStats getTicketsStatisticsPerMonth(@RequestBody TicketStatisticksPerMonthRequest request) {
        return reporteTicketsService.getTicketStatisticsPerMonth(request);
    }

    @PostMapping("/tickets/get-ticket-statistics-per-status-monthly")
    public TicketsStatusStats getTicketStatisticsPerStatusMonthly(@RequestBody TicketStatisticksPerMonthRequest request) {
        return reporteTicketsService.getTicketStatisticsPerStatusMonthly(request);
    }

    @PostMapping("/tickets/get-report-per-person")
    public List<ReportPerPerson> getReportPerPerson(@RequestBody ReportPerPersonRequest request) {
        return reporteTicketsService.getReportPerPerson(request);
    }

}

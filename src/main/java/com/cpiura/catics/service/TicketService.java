package com.cpiura.catics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpiura.catics.entity.Ticket;
import com.cpiura.catics.repository.TicketRepository;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    // private ReporteTicketsRepository reporteTicketsRepository;


    public List<Ticket> getTop10Tickets() {
        return ticketRepository.findTop10ByOrderByIdDesc(); // Llama al método del repositorio
    }

}
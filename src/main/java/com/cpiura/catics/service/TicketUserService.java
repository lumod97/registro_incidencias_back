package com.cpiura.catics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpiura.catics.entity.TicketUser;
import com.cpiura.catics.repository.TicketUserRepository;

@Service
public class TicketUserService {
    @Autowired
    private TicketUserRepository ticketUserRepository;

    public List<TicketUser> getTop10Tickets() {
        return ticketUserRepository.findTop10ByOrderByIdDesc(); // Llama al método del repositorio
    }
}
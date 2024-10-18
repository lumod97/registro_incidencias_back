package com.cpiura.catics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpiura.catics.entity.GroupTicket;
import com.cpiura.catics.repository.GroupTicketRepository;

@Service
public class GroupTicketService {
    @Autowired
    private GroupTicketRepository groupTicketRepository;

    public List<GroupTicket> getTop10Tickets() {
        return groupTicketRepository.findTop10ByOrderByIdDesc(); // Llama al método del repositorio
    }
}

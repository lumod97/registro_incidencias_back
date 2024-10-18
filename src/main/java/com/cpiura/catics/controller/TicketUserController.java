package com.cpiura.catics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpiura.catics.entity.TicketUser;
import com.cpiura.catics.service.TicketUserService;

@RestController

public class TicketUserController {
    @Autowired
    private TicketUserService ticketUserService;

    @GetMapping("/ticket_user/top10")
    public List<TicketUser> getTop10Tickets() {
        return ticketUserService.getTop10Tickets(); // Calls the service to get the tickets
    }
}

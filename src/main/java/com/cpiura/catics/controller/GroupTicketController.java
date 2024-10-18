package com.cpiura.catics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpiura.catics.entity.GroupTicket;
import com.cpiura.catics.service.GroupTicketService;

@RestController

public class GroupTicketController {
    @Autowired
    private GroupTicketService groupTicketService;

    @GetMapping("/group_ticket/top10")
    public List<GroupTicket> getTop10Tickets() {
        return groupTicketService.getTop10Tickets(); // Calls the service to get the tickets
    }
}

// package com.cpiura.catics.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.cpiura.catics.entity.Ticket;
// import com.cpiura.catics.service.TicketService;



// @RestController
// public class TicketController {

//     @Autowired
//     private TicketService ticketService;

//     @GetMapping("/tickets/top10")
//     public List<Ticket> getTop10Tickets() {
//         return ticketService.getTop10Tickets(); // Calls the service to get the tickets
//     }
    
// }
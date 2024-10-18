package com.cpiura.catics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpiura.catics.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findTop10ByOrderByIdDesc(); // If you want to order by the 'date' field

    // @Query(value = "CALL sp_get_ticket_report", nativeQuery = true)
    // List<ReporteTickets> getTicketReport();
}
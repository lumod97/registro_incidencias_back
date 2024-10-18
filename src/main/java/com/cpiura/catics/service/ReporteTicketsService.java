package com.cpiura.catics.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpiura.catics.entity.ReporteTickets;

import jakarta.persistence.EntityManager;
import jakarta.persistence.StoredProcedureQuery;


@Service
public class ReporteTicketsService {

    @Autowired
    private EntityManager entityManager;

    public List<ReporteTickets> getTicketsReport() {
        // Crear una consulta de procedimiento almacenado
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_get_ticket_report");
        
        // Ejecutar la consulta y obtener resultados
        @SuppressWarnings("unchecked")
        List<Object[]> resultList = query.getResultList();
        
        // Convertir el resultado a una lista de TicketReport
        List<ReporteTickets> ticketReports = new ArrayList<>();
        for (Object[] row : resultList) {
            ReporteTickets ticketReport = new ReporteTickets(
                (String) row[0],                             // CATIC
                (String) row[1],                              // Detalle
                ((java.util.Date) row[2]).toInstant()       // Ingreso (TIMESTAMP)
                        .atZone(java.time.ZoneId.systemDefault()).toLocalDateTime(),
                ((java.util.Date) row[3]).toInstant()       // Asignacion (DATETIME)
                        .atZone(java.time.ZoneId.systemDefault()).toLocalDateTime(),
                (String) row[4],                              // Prioridad
                (String) row[5],                              // Estado
                (String) row[6],                              // Tipo
                (String) row[7],                              // User Dev
                ((java.util.Date) row[8]).toInstant()       // Fec Dev (DATETIME)
                        .atZone(java.time.ZoneId.systemDefault()).toLocalDateTime(),
                (String) row[9],                              // User QA
                ((java.util.Date) row[10]).toInstant()      // Fec QA (TIMESTAMP)
                        .atZone(java.time.ZoneId.systemDefault()).toLocalDateTime(),
                (String) row[11],                             // User CC
                ((java.util.Date) row[12]).toInstant()      // Fec CC (TIMESTAMP)
                        .atZone(java.time.ZoneId.systemDefault()).toLocalDateTime(),
                (String) row[13],                             // User Prod
                ((java.util.Date) row[14]).toInstant()      // Fec Prod (TIMESTAMP)
                        .atZone(java.time.ZoneId.systemDefault()).toLocalDateTime(),
                (String) row[15],                             // Bandeja
                (String) row[16],                             // Garantia
                (String) row[17]                              // Categoria
            );
            ticketReports.add(ticketReport);
        }
        
        return ticketReports;
    }
}

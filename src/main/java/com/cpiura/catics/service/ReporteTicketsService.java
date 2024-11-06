package com.cpiura.catics.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpiura.catics.Request.ReportPerPersonRequest;
import com.cpiura.catics.Request.TicketStatisticksPerMonthRequest;
import com.cpiura.catics.entity.ReportPerPerson;
import com.cpiura.catics.entity.ReporteTickets;
import com.cpiura.catics.entity.TicketsPriorityStats;
import com.cpiura.catics.entity.TicketsStatusStats;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class ReporteTicketsService {

        @Autowired
        private EntityManager entityManager;

        public TicketsPriorityStats getTicketStatisticsPerMonth(TicketStatisticksPerMonthRequest request) {
                StoredProcedureQuery query = entityManager.createStoredProcedureQuery(
                                "sp_get_ticket_statistics_per_month");

                // Registra los parámetros con sus tipos y modos
                query.registerStoredProcedureParameter(0, String.class, ParameterMode.IN);
                query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);

                // Configura los valores de los parámetros
                query.setParameter(0, request.getAnio());
                query.setParameter(1, request.getMonth());
                @SuppressWarnings("unchecked")
                List<Object[]> results = query.getResultList();

                // Crear un objeto de TicketsPriorityStats y llenarlo con valores
                // predeterminados
                TicketsPriorityStats stats = new TicketsPriorityStats(0, 0, 0, 0);

                // Procesar los resultados
                for (Object[] row : results) {
                        Long cantidad = (Long) row[0]; // cantidad
                        String prioridad = (String) row[1]; // prioridad

                        // Incrementar el campo correspondiente en la entidad
                        switch (prioridad.toLowerCase()) {
                                case "low" -> stats.setLow(cantidad.intValue());
                                case "medium" -> stats.setMedium(cantidad.intValue());
                                case "high" -> stats.setHigh(cantidad.intValue());
                                case "critical" -> stats.setCritical(cantidad.intValue());
                                default -> {
                                }
                        }
                }

                return stats;
        }

        public TicketsStatusStats getTicketStatisticsPerStatusMonthly(TicketStatisticksPerMonthRequest request) {
                StoredProcedureQuery query = entityManager.createStoredProcedureQuery(
                                "sp_get_ticket_statistics_per_status_monthly");

                // Registra los parámetros con sus tipos y modos
                query.registerStoredProcedureParameter(0, String.class, ParameterMode.IN);
                query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);

                // Configura los valores de los parámetros
                query.setParameter(0, request.getAnio());
                query.setParameter(1, request.getMonth());
                @SuppressWarnings("unchecked")
                List<Object[]> results = query.getResultList();

                // Crear un objeto de TicketsPriorityStats y llenarlo con valores
                // predeterminados
                TicketsStatusStats stats = new TicketsStatusStats(0, 0, 0, 0, 0, 0, 0);

                // Procesar los resultados
                for (Object[] row : results) {
                        Long cantidad = (Long) row[0]; // cantidad
                        String estado = (String) row[1]; // estado

                        // Incrementar el campo correspondiente en la entidad
                        switch (estado.toLowerCase()) {
                                case "new_ticket" -> stats.setNew_ticket(cantidad.intValue());
                                case "assigned" -> stats.setAssigned(cantidad.intValue());
                                case "in_course" -> stats.setIn_course(cantidad.intValue());
                                case "pending" -> stats.setPending(cantidad.intValue());
                                case "solved" -> stats.setSolved(cantidad.intValue());
                                case "closed" -> stats.setClosed(cantidad.intValue());
                                case "canceled" -> stats.setCanceled(cantidad.intValue());
                                default -> {
                                }
                        }
                }

                return stats;
        }
        
        public List<ReportPerPerson> getReportPerPerson(ReportPerPersonRequest request) {
                StoredProcedureQuery query = entityManager.createStoredProcedureQuery(
                                "get_report_per_person");
                                // "get_report_per_person ('2024-10-01', '2024-10-31', 1, 50);");

                // Registra los parámetros con sus tipos y modos
                query.registerStoredProcedureParameter(0, String.class, ParameterMode.IN);
                query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
                query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);
                query.registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN);

                // Configura los valores de los parámetros
                query.setParameter(0, request.getDate_from());
                query.setParameter(1, request.getDate_to());
                query.setParameter(2, request.getOffset());
                query.setParameter(3, request.getLimit());
                @SuppressWarnings("unchecked")
                List<Object[]> results = query.getResultList();

                // Crear un objeto de TicketsPriorityStats y llenarlo con valores
                // predeterminados
                List<ReportPerPerson> stats = new ArrayList<>();
                
                // Procesar los resultados
                for (Object[] row : results) {
                        ReportPerPerson item = new ReportPerPerson(0, null, null, 0, 0, 0, 0, 0, 0, null);
                        Integer id = (Integer) Integer.parseInt(row[0].toString()); // cantidad
                        String user = (String) row[1] != null ? row[1].toString() : ""; // estado
                        String charge = (String) row[2] != null ? row[2].toString() : ""; // estado
                        Integer news = (Integer) Integer.parseInt(row[3].toString()); // estado
                        Integer assigned = (Integer) Integer.parseInt(row[4].toString()); // estado
                        Integer in_course = (Integer) Integer.parseInt(row[5].toString()); // estado
                        Integer pending = (Integer) Integer.parseInt(row[6].toString()); // estado
                        Integer solved = (Integer) Integer.parseInt(row[7].toString()); // estado
                        Integer closed = (Integer) Integer.parseInt(row[8].toString()); // estado
                        Integer cancelled = (Integer) Integer.parseInt(row[9].toString()); // estado

                        item.setId(id);
                        item.setUser(user);
                        item.setCharge(charge);
                        item.setNews(news);
                        item.setAssigneds(assigned);
                        item.setIn_course(in_course);
                        item.setPending(pending);
                        item.setSolved(solved);
                        item.setClosed(closed);
                        item.setCancelled(cancelled);

                        stats.add(item);
                }

                return stats;
        }
        
        public List<ReporteTickets> getTicketsReport() {
                // Crear una consulta de procedimiento almacenado
                StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_get_ticket_report");

                // Ejecutar la consulta y obtener resultados
                @SuppressWarnings("unchecked")
                List<Object[]> resultList = query.getResultList();

                // Convertir el resultado a una lista de ReporteTickets
                List<ReporteTickets> ticketReports = new ArrayList<>();
                for (Object[] row : resultList) {
                        // Ejemplo de llamada ajustada al constructor
                        ReporteTickets ticketReport = new ReporteTickets(
                                        (Integer) row[0], // catic
                                        (String) row[1], // detalle
                                        // : null, // fechaAsignacion
                                        (String) row[2], // prioridad
                                        (String) row[3], // prioridad
                                        (String) row[4], // prioridad
                                        (String) row[5], // estado
                                        (String) row[6], // tipo
                                        (String) row[7], // userDev
                                        (String) row[8], // userDev
                                        (String) row[9], // userQA
                                        (String) row[10], // userCC
                                        (String) row[11], // userCC
                                        (String) row[12], // userProd
                                        (String) row[13], // userProd
                                        (String) row[14], // bandeja
                                        (String) row[15], // garantia
                                        (String) row[16] // categoria
                        );
                        ticketReports.add(ticketReport);
                }

                return ticketReports;
        }

        public TicketsPriorityStats getTicketsPriorityStatistics() {
                StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_get_ticket_statistics");
                @SuppressWarnings("unchecked")
                List<Object[]> results = query.getResultList();

                // Crear un objeto de TicketsPriorityStats y llenarlo con valores
                // predeterminados
                TicketsPriorityStats stats = new TicketsPriorityStats(0, 0, 0, 0);

                // Procesar los resultados
                for (Object[] row : results) {
                        Long cantidad = (Long) row[0]; // cantidad
                        String prioridad = (String) row[1]; // prioridad

                        // Incrementar el campo correspondiente en la entidad
                        switch (prioridad.toLowerCase()) {
                                case "low" -> stats.setLow(cantidad.intValue());
                                case "medium" -> stats.setMedium(cantidad.intValue());
                                case "high" -> stats.setHigh(cantidad.intValue());
                                case "critical" -> stats.setCritical(cantidad.intValue());
                                default -> {
                                }
                        }
                }

                return stats;
        }
}

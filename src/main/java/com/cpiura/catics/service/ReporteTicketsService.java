package com.cpiura.catics.service;

// import java.sql.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpiura.catics.entity.ReporteTickets;
import com.cpiura.catics.entity.TicketsPriorityStats;

import jakarta.persistence.EntityManager;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class ReporteTicketsService {

        @Autowired
        private EntityManager entityManager;

        public String getColumnInfoFromSP() {
                StringBuilder result = new StringBuilder();
                Connection connection = null;
                java.sql.CallableStatement callableStatement = null;
                ResultSet resultSet = null;

                try {
                        // Establecer la conexión a la base de datos (ajusta los valores según tu
                        // configuración)
                        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/glpiprod", "root",
                                        "12345");

                        // Preparar el CallableStatement para ejecutar el procedimiento almacenado
                        callableStatement = connection.prepareCall("{CALL sp_get_ticket_report()}");

                        // Ejecutar el SP y obtener el ResultSet
                        resultSet = callableStatement.executeQuery();

                        // Obtener metadata del ResultSet
                        java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
                        int columnCount = metaData.getColumnCount();

                        // Iterar sobre las columnas y obtener el nombre y tipo de dato
                        for (int i = 1; i <= columnCount; i++) {
                                String columnName = metaData.getColumnName(i);
                                String columnType = metaData.getColumnTypeName(i);
                                result.append("Columna: ").append(columnName).append(" - Tipo: ").append(columnType)
                                                .append("\n");
                        }

                } catch (SQLException e) {
                        e.printStackTrace();
                } finally {
                        try {
                                if (resultSet != null)
                                        resultSet.close();
                                if (callableStatement != null)
                                        callableStatement.close();
                                if (connection != null)
                                        connection.close();
                        } catch (SQLException e) {
                                e.printStackTrace();
                        }
                }

                return result.toString();
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
                                case "low":
                                        stats.setLow(cantidad.intValue());
                                        break;
                                case "medium":
                                        stats.setMedium(cantidad.intValue());
                                        break;
                                case "high":
                                        stats.setHigh(cantidad.intValue());
                                        break;
                                case "critical":
                                        stats.setCritical(cantidad.intValue());
                                        break;
                                default:
                                        break;
                        }
                }

                return stats;
        }
}

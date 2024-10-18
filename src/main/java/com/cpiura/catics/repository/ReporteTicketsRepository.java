// package com.cpiura.catics.repository;

// import java.util.List;

// import org.springframework.stereotype.Repository;

// import com.cpiura.catics.entity.ReporteTickets;

// import jakarta.persistence.EntityManager;
// import jakarta.persistence.PersistenceContext;
// import jakarta.persistence.StoredProcedureQuery;

// @Repository
// public class ReporteTicketsRepository {

//     @PersistenceContext
//     private EntityManager entityManager;

//     @SuppressWarnings("unchecked")
//     public List<ReporteTickets> callStoredProcedure() {
//         StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_get_ticket_report", ReporteTickets.class);
//         return query.getResultList();
//     }
// }

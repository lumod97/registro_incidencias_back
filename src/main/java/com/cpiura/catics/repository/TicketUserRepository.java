package com.cpiura.catics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpiura.catics.entity.TicketUser;

@Repository
public interface TicketUserRepository extends JpaRepository<TicketUser, Integer> {
    List<TicketUser> findTop10ByOrderByIdDesc(); // If you want to order by the 'date' field
}

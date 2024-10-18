package com.cpiura.catics.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "glpi_groups_tickets", 
       uniqueConstraints = {@UniqueConstraint(columnNames = {"tickets_id", "type", "groups_id"})},
       indexes = {@Index(name = "group", columnList = "groups_id, type")}
)
public class GroupTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tickets_id", nullable = false, columnDefinition = "int default 0")
    private int ticketsId;

    @Column(name = "groups_id", nullable = false, columnDefinition = "int default 0")
    private int groupsId;

    @Column(name = "type", nullable = false, columnDefinition = "int default 1")
    private int type;
}
package com.cpiura.catics.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "glpi_tickets_users")
public class TicketUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tickets_id", nullable = false, columnDefinition = "int default 0")
    private int ticketsId;

    @Column(name = "users_id", nullable = false, columnDefinition = "int default 0")
    private int usersId;

    @Column(name = "type", nullable = false, columnDefinition = "int default 1")
    private int type;

    @Column(name = "use_notification", nullable = false, columnDefinition = "tinyint(1) default 1")
    private boolean useNotification;

    @Column(name = "alternative_email", length = 255, columnDefinition = "varchar(255)")
    private String alternativeEmail;

}

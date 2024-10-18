package com.cpiura.catics.entity;

import java.sql.Timestamp;

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
@Table(name = "glpi_tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "entities_id", nullable = false)
    private int entitiesId;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "date")
    private Timestamp date;

    @Column(name = "closedate")
    private Timestamp closeDate;

    @Column(name = "solvedate")
    private Timestamp solveDate;

    @Column(name = "date_mod")
    private Timestamp dateMod;

    @Column(name = "users_id_lastupdater", nullable = false)
    private int usersIdLastUpdater;

    @Column(name = "status", nullable = false)
    private int status;

    @Column(name = "users_id_recipient", nullable = false)
    private int usersIdRecipient;

    @Column(name = "requesttypes_id", nullable = false)
    private int requestTypesId;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "urgency", nullable = false)
    private int urgency;

    @Column(name = "impact", nullable = false)
    private int impact;

    @Column(name = "priority", nullable = false)
    private int priority;

    @Column(name = "itilcategories_id", nullable = false)
    private int itilCategoriesId;

    @Column(name = "type", nullable = false)
    private int type;

    @Column(name = "global_validation", nullable = false)
    private int globalValidation;

    @Column(name = "slas_id_ttr", nullable = false)
    private int slasIdTtr;

    @Column(name = "slas_id_tto", nullable = false)
    private int slasIdTto;

    @Column(name = "slalevels_id_ttr", nullable = false)
    private int slalevelsIdTtr;

    @Column(name = "time_to_resolve")
    private Timestamp timeToResolve;

    @Column(name = "time_to_own")
    private Timestamp timeToOwn;

    @Column(name = "begin_waiting_date")
    private Timestamp beginWaitingDate;

    @Column(name = "sla_waiting_duration", nullable = false)
    private int slaWaitingDuration;

    @Column(name = "ola_waiting_duration", nullable = false)
    private int olaWaitingDuration;

    @Column(name = "olas_id_tto", nullable = false)
    private int olasIdTto;

    @Column(name = "olas_id_ttr", nullable = false)
    private int olasIdTtr;

    @Column(name = "olalevels_id_ttr", nullable = false)
    private int olaLevelsIdTtr;

    @Column(name = "ola_ttr_begin_date")
    private Timestamp olaTtrBeginDate;

    @Column(name = "internal_time_to_resolve")
    private Timestamp internalTimeToResolve;

    @Column(name = "internal_time_to_own")
    private Timestamp internalTimeToOwn;

    @Column(name = "waiting_duration", nullable = false)
    private int waitingDuration;

    @Column(name = "close_delay_stat", nullable = false)
    private int closeDelayStat;

    @Column(name = "solve_delay_stat", nullable = false)
    private int solveDelayStat;

    @Column(name = "takeintoaccount_delay_stat", nullable = false)
    private int takeIntoAccountDelayStat;

    @Column(name = "actiontime", nullable = false)
    private int actionTime;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @Column(name = "locations_id", nullable = false)
    private int locationsId;

    @Column(name = "validation_percent", nullable = false)
    private int validationPercent;

    @Column(name = "date_creation")
    private Timestamp dateCreation;


}

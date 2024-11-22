package com.cpiura.catics.entity;

import java.security.Timestamp;

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
@Table(name = "glpi_itilcategories")
public class ItilCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "entities_id", nullable = false, columnDefinition = "int default 0")
    private int entitiesId;

    @Column(name = "is_recursive", nullable = false, columnDefinition = "tinyint(1) default 0")
    private boolean isRecursive;

    @Column(name = "itilcategories_id", nullable = false, columnDefinition = "int default 0")
    private int itilCategoriesId;

    @Column(name = "name", length = 255, columnDefinition = "varchar(255)")
    private String name;

    @Column(name = "completename", columnDefinition = "text")
    private String completeName;

    @Column(name = "comment", columnDefinition = "text")
    private String comment;

    @Column(name = "level", nullable = false, columnDefinition = "int default 0")
    private int level;

    @Column(name = "knowbaseitemcategories_id", nullable = false, columnDefinition = "int default 0")
    private int knowbaseItemCategoriesId;

    @Column(name = "users_id", nullable = false, columnDefinition = "int default 0")
    private int usersId;

    @Column(name = "groups_id", nullable = false, columnDefinition = "int default 0")
    private int groupsId;

    @Column(name = "code", length = 255, columnDefinition = "varchar(255)")
    private String code;

    @Column(name = "ancestors_cache", columnDefinition = "longtext")
    private String ancestorsCache;

    @Column(name = "sons_cache", columnDefinition = "longtext")
    private String sonsCache;

    @Column(name = "is_helpdeskvisible", nullable = false, columnDefinition = "tinyint(1) default 1")
    private boolean isHelpdeskVisible;

    @Column(name = "tickettemplates_id_incident", nullable = false, columnDefinition = "int default 0")
    private int ticketTemplatesIdIncident;

    @Column(name = "tickettemplates_id_demand", nullable = false, columnDefinition = "int default 0")
    private int ticketTemplatesIdDemand;

    @Column(name = "changetemplates_id", nullable = false, columnDefinition = "int default 0")
    private int changeTemplatesId;

    @Column(name = "problemtemplates_id", nullable = false, columnDefinition = "int default 0")
    private int problemTemplatesId;

    @Column(name = "is_incident", nullable = false, columnDefinition = "int default 1")
    private int isIncident;

    @Column(name = "is_request", nullable = false, columnDefinition = "int default 1")
    private int isRequest;

    @Column(name = "is_problem", nullable = false, columnDefinition = "int default 1")
    private int isProblem;

    @Column(name = "is_change", nullable = false, columnDefinition = "tinyint(1) default 1")
    private boolean isChange;

    @Column(name = "date_mod")
    private Timestamp dateMod;

    @Column(name = "date_creation")
    private Timestamp dateCreation;

}

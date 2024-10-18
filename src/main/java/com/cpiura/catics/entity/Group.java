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
@Table(name = "glpi_groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "entities_id", nullable = false, columnDefinition = "int default 0")
    private int entitiesId;

    @Column(name = "is_recursive", nullable = false, columnDefinition = "tinyint(1) default 0")
    private boolean isRecursive;

    @Column(name = "name", length = 255, columnDefinition = "varchar(255)")
    private String name;

    @Column(name = "comment", columnDefinition = "text")
    private String comment;

    @Column(name = "ldap_field", length = 255, columnDefinition = "varchar(255)")
    private String ldapField;

    @Column(name = "ldap_value", columnDefinition = "text")
    private String ldapValue;

    @Column(name = "ldap_group_dn", columnDefinition = "text")
    private String ldapGroupDn;

    @Column(name = "date_mod")
    private Timestamp dateMod;

    @Column(name = "groups_id", nullable = false, columnDefinition = "int default 0")
    private int groupsId;

    @Column(name = "completename", columnDefinition = "text")
    private String completeName;

    @Column(name = "level", nullable = false, columnDefinition = "int default 0")
    private int level;

    @Column(name = "ancestors_cache", columnDefinition = "longtext")
    private String ancestorsCache;

    @Column(name = "sons_cache", columnDefinition = "longtext")
    private String sonsCache;

    @Column(name = "is_requester", nullable = false, columnDefinition = "tinyint(1) default 1")
    private boolean isRequester;

    @Column(name = "is_watcher", nullable = false, columnDefinition = "tinyint(1) default 1")
    private boolean isWatcher;

    @Column(name = "is_assign", nullable = false, columnDefinition = "tinyint(1) default 1")
    private boolean isAssign;

    @Column(name = "is_task", nullable = false, columnDefinition = "tinyint(1) default 1")
    private boolean isTask;

    @Column(name = "is_notify", nullable = false, columnDefinition = "tinyint(1) default 1")
    private boolean isNotify;

    @Column(name = "is_itemgroup", nullable = false, columnDefinition = "tinyint(1) default 1")
    private boolean isItemGroup;

    @Column(name = "is_usergroup", nullable = false, columnDefinition = "tinyint(1) default 1")
    private boolean isUserGroup;

    @Column(name = "is_manager", nullable = false, columnDefinition = "tinyint(1) default 1")
    private boolean isManager;

    @Column(name = "date_creation")
    private Timestamp dateCreation;

}

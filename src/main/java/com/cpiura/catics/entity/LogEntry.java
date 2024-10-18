package com.cpiura.catics.entity;

import java.time.LocalDateTime;

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
@Table(name = "glpi_logs")
public class LogEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Se asume que hay una columna id como clave primaria

    @Column(name = "items_id", nullable = false)
    private int itemsId;

    @Column(name = "itemtype_link", nullable = false, length = 255)
    private String itemTypeLink;

    @Column(name = "user_name", nullable = false, length = 255)
    private String userName;

    @Column(name = "date_mod", nullable = false)
    private LocalDateTime dateMod;

    @Column(name = "new_value", length = 255)
    private String newValue;
}
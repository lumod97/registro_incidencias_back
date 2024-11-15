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

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "glpi_metas")
public class Metas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // La estrategia para generar automáticamente el id
    @Column(name = "id", nullable = false)
    private Integer 
    id;
    
    @Column(name = "periodo", nullable = false)
    private String periodo;

    @Column(name = "user_id", nullable=false)
    private String userId;

    @Column(name="meta", nullable=false)
    private Integer meta;
}

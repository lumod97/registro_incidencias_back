package com.cpiura.catics.entity;

// import java.time.String;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReporteTickets {
    private Integer catic;
    private String detalle; // Único campo detalle
    private String ingreso; // Cambiado a String
    private String asignacion; // Cambiado a String
    private String prioridad;
    private String estado;
    private String tipo;
    private String userDev;
    private String fecDev; // Cambiado a String
    private String userQA;
    private String userCC;
    private String fecQA; // Cambiado a String
    private String userProd;
    private String fecProd; // Cambiado a String
    private String bandeja;
    private String garantia;
    private String categoria;

    // Constructor
    public ReporteTickets(
            Integer catic,
            String detalle,
            String ingreso,
            String asignacion,
            String prioridad,
            String estado,
            String tipo,
            String userDev,
            String fecDev,
            String userQA,
            String userCC,
            String fecQA,
            String userProd,
            String fecProd,
            String bandeja,
            String garantia,
            String categoria
            ) {
        this.catic = catic;
        this.detalle = detalle; // Campo detalle único
        this.asignacion = asignacion;
        this.prioridad = prioridad; // Valor por defecto
        this.estado = estado;
        this.tipo = tipo;
        this.userDev = userDev;
        this.fecDev = fecDev;
        this.userQA = userQA;
        this.userCC = userCC;
        this.fecQA = fecQA;
        this.userProd = userProd;
        this.fecProd = fecProd;
        this.bandeja = bandeja;
        this.garantia = garantia;
        this.categoria = categoria;
    }

    // Getters y Setters
    // ...
}

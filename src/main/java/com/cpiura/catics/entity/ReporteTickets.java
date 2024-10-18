package com.cpiura.catics.entity;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReporteTickets {
    private String catic;                     // Campo INT
    private String detalle;                 // Campo VARCHAR
    private LocalDateTime ingreso;          // Campo TIMESTAMP
    private LocalDateTime asignacion;       // Campo DATETIME
    private String prioridad;                // Campo VARCHAR
    private String estado;                   // Campo VARCHAR
    private String tipo;                     // Campo VARCHAR
    private String userDev;                  // Campo VARCHAR
    private LocalDateTime fecDev;           // Campo DATETIME
    private String userQa;                   // Campo VARCHAR
    private LocalDateTime fecQa;            // Campo TIMESTAMP
    private String userCc;                   // Campo VARCHAR
    private LocalDateTime fecCc;            // Campo TIMESTAMP
    private String userProd;                 // Campo VARCHAR
    private LocalDateTime fecProd;          // Campo TIMESTAMP
    private String bandeja;                  // Campo VARCHAR
    private String garantia;                 // Campo VARCHAR
    private String category;                 // Campo TEXT

    // Constructor
    public ReporteTickets(String catic, String detalle, LocalDateTime ingreso, LocalDateTime asignacion,
                        String prioridad, String estado, String tipo, String userDev,
                        LocalDateTime fecDev, String userQa, LocalDateTime fecQa,
                        String userCc, LocalDateTime fecCc, String userProd,
                        LocalDateTime fecProd, String bandeja, String garantia, String category) {
        this.catic = catic;
        this.detalle = detalle;
        this.ingreso = ingreso;
        this.asignacion = asignacion;
        this.prioridad = prioridad;
        this.estado = estado;
        this.tipo = tipo;
        this.userDev = userDev;
        this.fecDev = fecDev;
        this.userQa = userQa;
        this.fecQa = fecQa;
        this.userCc = userCc;
        this.fecCc = fecCc;
        this.userProd = userProd;
        this.fecProd = fecProd;
        this.bandeja = bandeja;
        this.garantia = garantia;
        this.category = category;
    }

    // Getters y setters
    // ...
}

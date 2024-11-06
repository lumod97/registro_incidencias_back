package com.cpiura.catics.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetTicketsByUserId {
    private String catic;
    private String descripcion;
    private String fecha_creacion;
    private String fecha_cierre;
    private String fecha_resuelto;
    private Integer id;
    private String user_name;
    private String user_last_name;
    private String cargo;
    private String prioridad;
    private String estado;
    private String tipo;
}
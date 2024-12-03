package com.cpiura.catics.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TicketsDashboardPerMonth {
    private Integer solicitud_recibida;
    private Integer solicitud_atendida;
    private Integer incidencia_recibida;
    private Integer incidencia_atendida;
}

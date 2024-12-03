package com.cpiura.catics.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TicketsDashboardBandeja {
    private String torre;
    private BigDecimal dev;
    private BigDecimal qa;
    private BigDecimal prod;
    private BigDecimal total;
}

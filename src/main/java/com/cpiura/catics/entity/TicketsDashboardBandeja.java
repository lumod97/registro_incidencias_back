package com.cpiura.catics.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TicketsDashboardBandeja {
    private String torre;
    private Integer dev;
    private Integer qa;
    private Integer prod;
    private Integer total;
}

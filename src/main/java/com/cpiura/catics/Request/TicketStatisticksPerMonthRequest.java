package com.cpiura.catics.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TicketStatisticksPerMonthRequest {
    private String anio;
    private Integer month;
}

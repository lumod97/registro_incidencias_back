package com.cpiura.catics.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketsPriorityStats {
    private Integer low;
    private Integer medium;
    private Integer high;
    private Integer critical;

    public TicketsPriorityStats(
        Integer low, Integer medium, Integer high, Integer critical
    ){
        this.low = low;
        this.medium = medium;
        this.high = high;
        this.critical = critical;
    }
}

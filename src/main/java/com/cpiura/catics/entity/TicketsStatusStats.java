package com.cpiura.catics.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TicketsStatusStats {
    private Integer new_ticket;
    private Integer assigned;
    private Integer in_course;
    private Integer pending;
    private Integer solved;
    private Integer closed;
    private Integer canceled;
}

package com.cpiura.catics.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MetasFilteredDTO {
    private Integer id;
    private String periodo;
    private Integer meta;
    private String name;

    public MetasFilteredDTO(Integer id, String periodo, Integer meta, String name) {
        this.id = id;
        this.periodo = periodo;
        this.meta = meta;
        this.name = name;
    }
}

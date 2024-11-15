package com.cpiura.catics.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MetasRequest {
    private String periodo;
    private String userId;
    private Integer meta;
}

package com.cpiura.catics.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReportPerPersonRequest {
    private String date_from;
    private String date_to;
    private Integer offset;
    private Integer limit;
}

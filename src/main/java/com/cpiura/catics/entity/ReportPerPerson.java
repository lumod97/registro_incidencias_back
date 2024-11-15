package com.cpiura.catics.entity;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class ReportPerPerson {
    private Integer id;
    private String user;
    private String charge;
    private Integer news;
    private Integer assigneds;
    private Integer in_course;
    private Integer pending;
    private Integer solved;
    private Integer closed;
    private Integer cancelled;
    private Integer meta;

    public Integer getId() {
        return id;
    }
    public String getUser() {
        return user != null ? user : "NO USER";
    }
    public String getCharge() {
        return charge != null ? charge : "NO CHARGE";
    }
    public Integer getNews() {
        return news != null ? news : 0;
    }
    public Integer getAssigneds() {
        return assigneds != null ? assigneds : 0;
    }
    public Integer getIn_course() {
        return in_course != null ? in_course : 0;
    }
    public Integer getPending() {
        return pending != null ? pending : 0;
    }
    public Integer getSolved() {
        return solved != null ? solved : 0;
    }
    public Integer getClosed() {
        return closed != null ? closed : 0;
    }
    public Integer getCancelled() {
        return cancelled != null ? cancelled : 0;
    }
    public Integer getMeta() {
        return meta != null ? meta : 0;
    }
}





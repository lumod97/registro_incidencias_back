package com.cpiura.catics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpiura.catics.entity.Group;
import com.cpiura.catics.service.GroupService;

@RestController

public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping("/group/top10")
    public List<Group> getTop10Tickets() {
        return groupService.getTop10Tickets(); // Calls the service to get the tickets
    }
}

package com.cpiura.catics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpiura.catics.entity.ItilCategory;
import com.cpiura.catics.service.ItilCategoryService;

@RestController

public class ItilCategoryController {
    @Autowired
    private ItilCategoryService itilCategoryService;

    @GetMapping("/itil_category/top10")
    public List<ItilCategory> getTop10Tickets() {
        return itilCategoryService.getTop10Tickets(); // Calls the service to get the tickets
    }
}

package com.cpiura.catics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpiura.catics.service.GlpiNewTrabajadoresTorreService;

@RestController
@RequestMapping("/api/trabajadores-torre")
public class GlpiNewTrabajadoresTorreController {

    @Autowired
    private GlpiNewTrabajadoresTorreService service;

}

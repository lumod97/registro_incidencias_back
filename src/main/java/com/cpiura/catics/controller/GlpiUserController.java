package com.cpiura.catics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpiura.catics.service.GlpiUserService;

@RestController
@RequestMapping("/api/users")
public class GlpiUserController {

    @Autowired
    private GlpiUserService glpiUserService;
}

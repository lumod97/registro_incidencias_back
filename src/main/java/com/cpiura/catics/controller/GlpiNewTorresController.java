package com.cpiura.catics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpiura.catics.DTO.GlpiNewTorreRequest;
import com.cpiura.catics.service.GlpiNewTorresService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/torres")

public class GlpiNewTorresController {
    @Autowired
    private GlpiNewTorresService glpiNewTorresService;

    @PostMapping("/add-torre")
    public ResponseEntity<?> saveNewTorre(@RequestBody GlpiNewTorreRequest request) {
        try {
            glpiNewTorresService.saveNewTorre(request);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
        }
    }

}

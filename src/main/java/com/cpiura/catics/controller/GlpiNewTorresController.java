package com.cpiura.catics.controller;

import com.cpiura.catics.entity.GlpiNewTorres;
import com.cpiura.catics.service.GlpiNewTorresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/glpi-new-torres")
public class GlpiNewTorresController {

    @Autowired
    private GlpiNewTorresService service;

    @GetMapping
    public ResponseEntity<List<GlpiNewTorres>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlpiNewTorres> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<GlpiNewTorres> create(@RequestBody GlpiNewTorres glpiNewTorres) {
        return ResponseEntity.ok(service.save(glpiNewTorres));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GlpiNewTorres> update(@PathVariable Long id, @RequestBody GlpiNewTorres glpiNewTorres) {
        return service.findById(id).map(existing -> {
            existing.setNombre(glpiNewTorres.getNombre());
            existing.setDescripcion(glpiNewTorres.getDescripcion());
            return ResponseEntity.ok(service.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

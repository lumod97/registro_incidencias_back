package com.cpiura.catics.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpiura.catics.entity.GlpiNewTrabajadoresTorre;
import com.cpiura.catics.service.GlpiNewTrabajadoresTorreService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/glpi-new-trabajadores-torre")
public class GlpiNewTrabajadoresTorreController {

    @Autowired
    private GlpiNewTrabajadoresTorreService trabajadoresTorreService;

    // Obtener todos los trabajadores de la torre
    @GetMapping
    public ResponseEntity<List<GlpiNewTrabajadoresTorre>> getAllTrabajadoresTorre() {
        List<GlpiNewTrabajadoresTorre> trabajadoresTorre = trabajadoresTorreService.findAll();
        return ResponseEntity.ok(trabajadoresTorre);
    }

    // Obtener un trabajador por su ID
    @GetMapping("/{id}")
    public ResponseEntity<GlpiNewTrabajadoresTorre> getTrabajadoresTorreById(@PathVariable Long id) {
        Optional<GlpiNewTrabajadoresTorre> trabajadoresTorre = trabajadoresTorreService.findById(id);
        return trabajadoresTorre.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear o actualizar un trabajador de la torre
    @PostMapping
    public ResponseEntity<GlpiNewTrabajadoresTorre> createTrabajadoresTorre(
            @RequestBody GlpiNewTrabajadoresTorre trabajadoresTorre) {
        GlpiNewTrabajadoresTorre savedTrabajadoresTorre = trabajadoresTorreService.save(trabajadoresTorre);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTrabajadoresTorre);
    }

    // Actualizar un trabajador de la torre
    @PutMapping("/{id}")
    public ResponseEntity<GlpiNewTrabajadoresTorre> updateTrabajadoresTorre(@PathVariable Long id,
            @RequestBody GlpiNewTrabajadoresTorre trabajadoresTorre) {
        Optional<GlpiNewTrabajadoresTorre> existingTrabajadoresTorre = trabajadoresTorreService.findById(id);
        if (existingTrabajadoresTorre.isPresent()) {
            trabajadoresTorre.setId(id);
            GlpiNewTrabajadoresTorre updatedTrabajadoresTorre = trabajadoresTorreService.save(trabajadoresTorre);
            return ResponseEntity.ok(updatedTrabajadoresTorre);
        }
        return ResponseEntity.notFound().build();
    }

    // Eliminar un trabajador de la torre
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrabajadoresTorre(@PathVariable Long id) {
        trabajadoresTorreService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

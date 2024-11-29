package com.cpiura.catics.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpiura.catics.entity.GlpiUsers;
import com.cpiura.catics.service.GlpiUserService;

@RestController
@RequestMapping("/api/glpi-users")
public class GlpiUserController {

    @Autowired
    private GlpiUserService glpiUserService;

    // Obtener todos los usuarios
    @GetMapping
    public List<GlpiUsers> getAllUser() {
        return glpiUserService.getAllUsers();
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<GlpiUsers> getUserById(@PathVariable Integer id) {
        Optional<GlpiUsers> user = glpiUserService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo usuario
    @PostMapping
    public ResponseEntity<GlpiUsers> createUser(@RequestBody GlpiUsers user) {
        GlpiUsers createdUser = glpiUserService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    // Actualizar un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<GlpiUsers> updateUser(@PathVariable Integer id, @RequestBody GlpiUsers userDetails) {
        GlpiUsers updatedUser = glpiUserService.updateUser(id, userDetails);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }

    // Eliminar un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        glpiUserService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}

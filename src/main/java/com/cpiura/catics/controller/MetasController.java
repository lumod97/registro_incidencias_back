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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cpiura.catics.DTO.MetasFilteredDTO;
import com.cpiura.catics.Request.MetasRequest;
import com.cpiura.catics.Request.MetasRequestSearch;
import com.cpiura.catics.entity.Metas;
import com.cpiura.catics.service.MetasService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class MetasController {
    @Autowired
    private MetasService metasService;

    @GetMapping("/metas/get-all-metas")
    public List<Metas> getAllMetas() {
        return metasService.getMetas();
    }

    // @PostMapping("/metas/get-metas-filtered")
    // public List<Metas> getMetasFiltered(@RequestBody MetasRequestSearch requestSearch) {
    //     return metasService.getMetasFiltered(requestSearch);
    // }

    @PostMapping("/metas/get-metas-filtered")
    public List<MetasFilteredDTO> getMetasFiltered(@RequestBody MetasRequestSearch requestSearch) {
        // Llamar al servicio para obtener las metas filtradas
        return metasService.getMetasFiltered(requestSearch);
    }

    @PostMapping("/metas/new-meta")
    public ResponseEntity<?> insertMeta(@RequestBody MetasRequest request) {
        try {
            Metas newMeta = metasService.insertMeta(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(newMeta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear la meta");
        }
    }

    // Endpoint para eliminar una meta por su ID
    @DeleteMapping("/metas/delete-meta")
    public ResponseEntity<?> deleteMeta(@RequestParam Integer id) {
        // Lógica para eliminar la meta con el id proporcionado
        try {
            metasService.deleteMeta(id); // Llama al servicio para eliminar la meta
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar la meta");
        }
    }

    @PutMapping("/metas/update-meta/{id}")
public ResponseEntity<?> updateMeta(@PathVariable Integer id, @RequestBody Metas updatedMeta) {
    // Verificar si la meta con el id existe
    Optional<Metas> existingMeta = metasService.getMetaById(id);
    
    if (!existingMeta.isPresent()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Meta no encontrada");
    }
    
    // Actualizar la meta con los nuevos datos
    Metas metaToUpdate = existingMeta.get();
    metaToUpdate.setPeriodo(updatedMeta.getPeriodo());
    metaToUpdate.setMeta(updatedMeta.getMeta());
    // Actualizar otros campos de la meta si es necesario
    
    try {
        metasService.saveMeta(metaToUpdate); // Guardar la meta actualizada
        return ResponseEntity.ok(metaToUpdate); // Devolver la meta actualizada en la respuesta
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al actualizar la meta");
    }
}


}

package com.cpiura.catics.service;

import com.cpiura.catics.entity.GlpiNewTrabajadoresTorre;
import com.cpiura.catics.repository.GlpiNewTrabajadoresTorreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GlpiNewTrabajadoresTorreService {

    @Autowired
    private GlpiNewTrabajadoresTorreRepository repository;

    // Obtener todas las entidades
    public List<GlpiNewTrabajadoresTorre> findAll() {
        return repository.findAll();
    }

    // Obtener por ID
    public Optional<GlpiNewTrabajadoresTorre> findById(Long id) {
        return repository.findById(id);
    }

    // Guardar o actualizar una entidad
    public GlpiNewTrabajadoresTorre save(GlpiNewTrabajadoresTorre trabajadoresTorre) {
        return repository.save(trabajadoresTorre);
    }

    // Eliminar una entidad
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

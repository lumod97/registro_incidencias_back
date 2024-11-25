package com.cpiura.catics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpiura.catics.DTO.GlpiNewTorreRequest;
import com.cpiura.catics.entity.GlpiNewTorres;
import com.cpiura.catics.repository.GlpiNewTorresRepository;

@Service
public class GlpiNewTorresService {

    @Autowired
    private GlpiNewTorresRepository newTorresRepository;

    public GlpiNewTorres saveNewTorre(GlpiNewTorreRequest request) {
        GlpiNewTorres glpiNewTorre = new GlpiNewTorres();
        glpiNewTorre.setNombre(request.getNombre());
        glpiNewTorre.setDescripcion(request.getDescripcion());
        return newTorresRepository.save(glpiNewTorre);
    }
}

package com.cpiura.catics.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpiura.catics.entity.GlpiNewTorres;
import com.cpiura.catics.repository.GlpiNewTorresRepository;

import jakarta.transaction.Transactional;

@Service
public class GlpiNewTorresService {
    @Autowired
    private GlpiNewTorresRepository repository;

    public List<GlpiNewTorres> findAll() {
        return repository.findAll();
    }

    public Optional<GlpiNewTorres> findById(Long id) {
        return repository.findById(id);
    }

    public GlpiNewTorres save(GlpiNewTorres glpiNewTorres) {
        return repository.save(glpiNewTorres);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

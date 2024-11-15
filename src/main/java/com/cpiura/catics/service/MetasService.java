package com.cpiura.catics.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpiura.catics.DTO.MetasFilteredDTO;
import com.cpiura.catics.Request.MetasRequest;
import com.cpiura.catics.Request.MetasRequestSearch;
import com.cpiura.catics.entity.Metas;
import com.cpiura.catics.repository.MetasRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class MetasService {
    @Autowired
    private MetasRepository metasRepository;
    
    @PersistenceContext
    private EntityManager entityManager;

    public List<Metas> getMetas() {
        return metasRepository.findAll();
    }

    // public List<Metas> getMetasFiltered(MetasRequestSearch requestSearch) {
    //     return metasRepository.findByPeriodoOrUserId(requestSearch.getPeriodo(), requestSearch.getUserId());
    // }
    
    // Método para obtener las metas filtradas con JOIN usando consulta SQL nativa
    public List<MetasFilteredDTO> getMetasFiltered(MetasRequestSearch requestSearch) {
        // Consulta SQL nativa
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("GetMetasFiltered");
        // Asignar los parámetros de la consulta
        query.registerStoredProcedureParameter(0, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);

        query.setParameter(0, requestSearch.getPeriodo());
        query.setParameter(1, requestSearch.getUserId());

        // Obtener los resultados
        @SuppressWarnings("unchecked")
        List<Object[]> results = query.getResultList();

        // Crear una lista para almacenar las metas
        List<MetasFilteredDTO> metas = new ArrayList<>();

        // Procesar los resultados
        for (Object[] row : results) {
            Integer id = (Integer) row[0];  // id
            String periodo = (String) row[1];   // periodo
            Integer meta = (Integer) row[2];      // meta
            String name = (String) row[3];      // name

            // Mapear los resultados a un DTO
            MetasFilteredDTO metaDTO = new MetasFilteredDTO(id, periodo, meta, name);
            metas.add(metaDTO);
        }

        return metas;
    }

    public Metas insertMeta(MetasRequest request) {
        Metas meta = new Metas();
        meta.setPeriodo(request.getPeriodo());
        meta.setUserId(request.getUserId());
        meta.setMeta(request.getMeta());

        return metasRepository.save(meta);
    }

    // Método para eliminar una meta
    public boolean deleteMeta(Integer id) {
        if (metasRepository.existsById(id)) {
            metasRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Método para obtener una meta por su ID
    public Optional<Metas> getMetaById(Integer id) {
        return metasRepository.findById(id);
    }

    // Método para guardar una meta actualizada
    public Metas saveMeta(Metas meta) {
        return metasRepository.save(meta);
    }

}

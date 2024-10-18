package com.cpiura.catics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpiura.catics.entity.ItilCategory;
import com.cpiura.catics.repository.ItilCategoryRepository;

@Service
public class ItilCategoryService {
    @Autowired
    private ItilCategoryRepository itilCategoryRepository;

    public List<ItilCategory> getTop10Tickets() {
        return itilCategoryRepository.findTop10ByOrderByIdDesc(); // Llama al método del repositorio
    }
}

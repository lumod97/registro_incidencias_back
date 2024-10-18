package com.cpiura.catics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpiura.catics.entity.Group;
import com.cpiura.catics.repository.GroupRepository;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public List<Group> getTop10Tickets() {
        return groupRepository.findTop10ByOrderByIdDesc(); // Llama al método del repositorio
    }
}

package com.cpiura.catics.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpiura.catics.entity.Permission;
import com.cpiura.catics.repository.PermissionRepository;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    public Permission savePermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    public Optional<Permission> getPermissionById(Long id) {
        return permissionRepository.findById(id);
    }

    public void deletePermission(Long id) {
        permissionRepository.deleteById(id);
    }

    public Iterable<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }
}

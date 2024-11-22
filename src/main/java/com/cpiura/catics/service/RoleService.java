package com.cpiura.catics.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cpiura.catics.DTO.RegisterRoleRequest;
import com.cpiura.catics.entity.Role;
import com.cpiura.catics.repository.RoleRepository;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role saveRole(@RequestBody RegisterRoleRequest registerRoleRequest) {

        Role userRole = new Role();
        userRole.setName(registerRoleRequest.getName());
        userRole.setDescription(registerRoleRequest.getDescription());
        roleRepository.save(userRole);
        return roleRepository.save(userRole);

    }

    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    public Iterable<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    // public Role createRole(RegisterRoleRequest registerRoleRequest){

    // }
}

package com.cpiura.catics.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpiura.catics.entity.GlpiUsers;
import com.cpiura.catics.repository.GlpiUserRepository;

@Service
public class GlpiUserService {

    @Autowired
    private GlpiUserRepository glpiUsersRepository;

    public List<GlpiUsers> getAllUsers() {
        return glpiUsersRepository.findAll();
    }

    public Optional<GlpiUsers> getUserById(Integer id) {
        return glpiUsersRepository.findById(id);
    }

    public GlpiUsers createUser(GlpiUsers user) {
        return glpiUsersRepository.save(user);
    }

    public GlpiUsers updateUser(Integer id, GlpiUsers userDetails) {
        Optional<GlpiUsers> user = glpiUsersRepository.findById(id);
        if (user.isPresent()) {
            GlpiUsers existingUser = user.get();
            existingUser.setName(userDetails.getName());
            existingUser.setPassword(userDetails.getPassword());
            existingUser.setPhone(userDetails.getPhone());
            // Set other fields as necessary
            return glpiUsersRepository.save(existingUser);
        }
        return null; // or throw an exception
    }

    public void deleteUser(Integer id) {
        glpiUsersRepository.deleteById(id);
    }
}

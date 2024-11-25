package com.cpiura.catics.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cpiura.catics.DTO.RegisterRequest;
import com.cpiura.catics.Provider.JwtProvider;
import com.cpiura.catics.entity.Permission;
import com.cpiura.catics.entity.Person;
import com.cpiura.catics.entity.Role;
import com.cpiura.catics.entity.User;
import com.cpiura.catics.repository.PersonRepository;
import com.cpiura.catics.repository.RoleRepository;
import com.cpiura.catics.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RoleRepository roleRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Role> getUserRoles(Long userId) {
        return userRepository.findById(userId).map(User::getRoles).orElse(null);
    }

    public Set<Permission> getUserPermissions(Long userId) {
        return userRepository.findById(userId)
                .map(user -> user.getRoles().stream()
                        .flatMap(role -> role.getPermissions().stream())
                        .collect(Collectors.toSet()))
                .orElse(null);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean checkPassword(String rawPassword, String encryptedPassword) {
        return passwordEncoder.matches(rawPassword, encryptedPassword); // Usando BCrypt o similar
    }

    public String generateJwtToken(User user) {
        // Generar token con información del usuario
        return jwtProvider.generateToken(user.getUsername());
    }

    // Crear un nuevo usuario con la persona asociada
    public User createUser(@RequestBody RegisterRequest registerRequest) {
        Role userRole = roleRepository.findByName("ADMIN")
                .orElseThrow(() -> new RuntimeException("Rol 'ADMIN' no encontrado"));

        Person person = new Person();
        person.setFirstName(registerRequest.getFirstName());
        person.setLastName(registerRequest.getLastName());
        person.setBirthDate(registerRequest.getBirthDate());
        person.setAddress(registerRequest.getAddress());
        person.setPhoneNumber(registerRequest.getPhoneNumber());
        person.setDni(registerRequest.getDni());

        personRepository.save(person);

        String encodedPassword = passwordEncoder.encode(registerRequest.getPassword());

        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(encodedPassword);
        user.setActive(true);
        user.setRoles(Collections.singletonList(userRole));
        user.setPerson(person);

        person.setUser(user);

        return userRepository.save(user);
    }

}

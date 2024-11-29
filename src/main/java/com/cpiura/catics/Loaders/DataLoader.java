package com.cpiura.catics.Loaders;

import java.time.LocalDate;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cpiura.catics.entity.Permission;
import com.cpiura.catics.entity.Person;
import com.cpiura.catics.entity.Role;
import com.cpiura.catics.entity.User;
import com.cpiura.catics.repository.PermissionRepository;
import com.cpiura.catics.repository.PersonRepository;
import com.cpiura.catics.repository.RoleRepository;
import com.cpiura.catics.repository.UserRepository;

@Configuration
public class DataLoader {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    @Order(1)
    CommandLineRunner initPermissions(PermissionRepository permissionRepository) {
        return args -> {
            if (permissionRepository.findByName("create_users").isEmpty()) {
                Permission permission = new Permission();
                permission.setName("create_users");
                permission.setDescription("Permiso para crear usuarios");
                permissionRepository.save(permission);
            }

            if (permissionRepository.findByName("create_surveys").isEmpty()) {
                Permission permission = new Permission();
                permission.setName("create_surveys");
                permission.setDescription("Permiso para crear encuestas");
                permissionRepository.save(permission);
            }
        };
    }

    @Bean
    @Order(2)
    CommandLineRunner initRoles(RoleRepository roleRepository) {
        return args -> {
            if (roleRepository.findByName("USER").isEmpty()) {
                Role userRole = new Role();
                userRole.setName("USER");
                userRole.setDescription("Rol para usuario estandar");
                roleRepository.save(userRole);
            }

            if (roleRepository.findByName("ADMIN").isEmpty()) {
                Role adminRole = new Role();
                adminRole.setName("ADMIN");
                adminRole.setDescription("Rol para usuario administrador");
                roleRepository.save(adminRole);
            }
        };
    }

    @Bean
    @Order(3)
    CommandLineRunner initUser(UserRepository userRepository, PersonRepository personRepository,
            RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Buscar o crear la persona
            Person person = personRepository.findByDni("72450801")
                    .orElseGet(() -> {
                        Person newPerson = new Person();
                        newPerson.setFirstName("Administrador");
                        newPerson.setLastName("Del Sistema");
                        newPerson.setBirthDate(LocalDate.of(1997, 7, 8));
                        newPerson.setAddress("Cond. El Sol de Pomalca Mz K Lote 21 5ta Etapa");
                        newPerson.setPhoneNumber("946027276");
                        newPerson.setDni("72450801");
                        return personRepository.save(newPerson);
                    });

            // Validar existencia del usuario antes de crearlo
            userRepository.findByUsernameOrId("admin", Long.valueOf("1")).ifPresentOrElse(existingUser -> {
                // Ya existe el usuario, aseguramos la asociación con la persona
                if (existingUser.getPerson() == null) {
                    existingUser.setPerson(person);
                    userRepository.save(existingUser);
                }
            }, () -> {
                // Crear un nuevo usuario si no existe
                Role userRole = roleRepository.findByName("ADMIN")
                        .orElseThrow(() -> new RuntimeException("Rol 'ADMIN' no encontrado"));

                String encodedPassword = passwordEncoder.encode("adminUser");

                User newUser = new User();
                newUser.setUsername("admin");
                newUser.setEmail("luiggigmd.97@gmail.com");
                newUser.setPassword(encodedPassword);
                newUser.setActive(true);
                newUser.setRoles(Collections.singletonList(userRole));
                newUser.setPerson(person);

                // Establecer relación bidireccional
                person.setUser(newUser);

                userRepository.save(newUser);
            });
        };
    }
}
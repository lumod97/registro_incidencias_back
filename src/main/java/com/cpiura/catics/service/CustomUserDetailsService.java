package com.cpiura.catics.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Aquí debes cargar el usuario desde tu base de datos o fuente de datos
        // personalizada
        if (username.equals("admin")) { // Ejemplo simple
            return org.springframework.security.core.userdetails.User
                    .withUsername("admin")
                    .password("{noop}password") // Usa encriptación adecuada (BCrypt recomendado)
                    .roles("USER")
                    .build();
        }
        throw new UsernameNotFoundException("Usuario no encontrado: " + username);
    }
}

package com.cpiura.catics.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.cpiura.catics.Filter.JwtAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    // @Lazy aquí rompe la referencia circular, si es necesaria.
    public SecurityConfig(@Lazy JwtAuthenticationFilter jwtAuthenticationFilter,
            @Lazy AuthenticationProvider authenticationProvider) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.authenticationProvider = authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.cors()
                .and()
                .csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        // .requestMatchers("/api/auth/login", "/public/**", "/random-image",
                        // "/images/**", "/tickets/**"

                        .requestMatchers("/api/auth/login", "/public/**", "/random-image", "/images/**", "/tickets/**")
                        .permitAll() // Endpoints públicos
                        .anyRequest().authenticated() // Todo lo demás protegido
                )
                .authenticationProvider(authenticationProvider) // Proveedor de autenticación
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class) // Filtro JWT
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Provee el AuthenticationManager desde la configuración
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true); // Permitir credenciales como cookies y tokens
        config.addAllowedOrigin("http://localhost:4200"); // Cambia a la URL de tu frontend si es necesario
        config.addAllowedHeader("Authorization"); // Permitir el encabezado Authorization
        config.addAllowedHeader("*"); // Permitir otros encabezados
        config.addAllowedMethod("*"); // Permitir todos los métodos (GET, POST, PUT, DELETE, etc.)

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}

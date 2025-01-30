package com.cpiura.catics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpiura.catics.DTO.LoginRequest;
import com.cpiura.catics.DTO.LoginResponse;
import com.cpiura.catics.Exception.UserNotFoundException;
import com.cpiura.catics.entity.User;
import com.cpiura.catics.service.UserService;

import lombok.NoArgsConstructor;

//@CrossOrigin(origins = "http://localhost:4200")
// @CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
@NoArgsConstructor
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        // Buscar al usuario por username o email
        User user = userService.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));

        // Validar contraseña (compara la contraseña proporcionada con la almacenada)
        if (!userService.checkPassword(loginRequest.getPassword(), user.getPassword())) {
            System.out.println("Contraseña incorrecta");
            return ResponseEntity.status(401).body("Contraseña incorrecta");
        }

        // Verificar si el usuario está activo
        if (!user.isActive()) {
            System.out.println("Usuario no activo");
            return ResponseEntity.status(403).body("Usuario no activo");
        }

        // Generar token JWT
        String token = userService.generateJwtToken(user);

        // Imprimir el token en la consola
        System.out.println("Token generado: " + token);

        // Responder con datos del usuario y token
        return ResponseEntity.ok(new LoginResponse(user.getUsername(), token));
    }
}

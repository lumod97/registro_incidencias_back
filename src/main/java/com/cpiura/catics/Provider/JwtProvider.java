package com.cpiura.catics.Provider;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtProvider {

    @Value("${jwt.secret}")
    private String jwtSecret; // Clave secreta para firmar los tokens

    @Value("${jwt.expiration}")
    private long jwtExpiration; // Duración del token en milisegundos

    // Generar token JWT
    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpiration);

        // Convertir el jwtSecret a un Key (clave de tipo SecretKey)
        Key signingKey = new SecretKeySpec(jwtSecret.getBytes(), SignatureAlgorithm.HS512.getJcaName());

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(signingKey) // Usamos la clave en lugar de una cadena
                .compact();
    }

    // Obtener el usuario (subject) del token
    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    // Validar token
    public boolean validateToken(String token) {
        try {
            // Decodificar jwtSecret si es necesario (si está en Base64)
            byte[] keyBytes = java.util.Base64.getDecoder().decode(jwtSecret);

            // Construir un JwtParser con el nuevo builder
            JwtParser parser = Jwts.parserBuilder()
                    .setSigningKey(keyBytes)
                    .build();

            // Validar el token
            parser.parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            // Manejar excepciones como token expirado, firma inválida, etc.
            System.out.println("JWT validation failed: " + e.getMessage());
            return false;
        }
    }
}

package com.cpiura.catics.Filter;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Value("${jwt.secret}")
    private static String jwtSecret; // Clave secreta para firmar los tokens

    private static final String HEADER = "Authorization";
    private static final String PREFIX = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException, java.io.IOException {
        String jwtToken = getJwtFromRequest(request);
        System.out.println("doFilterInternal");

        if (jwtToken != null && validateToken(jwtToken)) {
            Claims claims = extractClaims(jwtToken);
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    claims.getSubject(), null, Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    // Extrae el token JWT de los encabezados de la solicitud
    private String getJwtFromRequest(HttpServletRequest request) {
        System.out.println("getJwtFromRequest");
        String bearerToken = request.getHeader(HEADER);
        System.out.println(bearerToken);
        if (bearerToken != null && bearerToken.startsWith(PREFIX)) {
            return bearerToken.substring(7); // Elimina el prefijo "Bearer " del token
        }
        return null;
    }

    // Valida el token JWT
    private boolean validateToken(String token) {
        System.out.println("validateToken");
        try {
            extractClaims(token); // Si no lanza excepciones, el token es válido
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Extrae los claims (información del usuario) del token
    private Claims extractClaims(String token) {
        System.out.println("extractClaims");
        // Decodificar jwtSecret si es necesario (si está en Base64)
        byte[] keyBytes = java.util.Base64.getDecoder().decode(jwtSecret);

        // Construir un JwtParser con el nuevo builder
        JwtParser parser = Jwts.parserBuilder()
                .setSigningKey(keyBytes)
                .build();

        // Validar el token
        return parser.parseClaimsJws(token).getBody();
    }

}

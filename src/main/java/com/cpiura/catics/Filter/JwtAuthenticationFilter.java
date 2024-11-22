package com.cpiura.catics.Filter;

import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final String SECRET_KEY = "q7ne4SuV0VmUtkE1Ehabc4sdBAzAUBWJPWsS6DcHBea+E+coxWym2sVH9dyyyIkcBgjNtj0DcsGebi8oC/W2bg=="; // Usa
    // una
    // clave
    // secreta
    // robusta
    // en
    // producción
    private static final String HEADER = "Authorization";
    private static final String PREFIX = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException, java.io.IOException {
        String jwtToken = getJwtFromRequest(request);

        if (jwtToken != null && validateToken(jwtToken)) {
            Claims claims = extractClaims(jwtToken);
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    claims.getSubject(), null, Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
            // authentication.setAuthenticated(true);
            // authentication.setDetails(new
            // WebAuthenticationDetailsSource().buildDetails(request));

            // Establecer la autenticación en el contexto de seguridad de Spring
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    // Extrae el token JWT de los encabezados de la solicitud
    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader(HEADER);
        System.out.println(bearerToken);
        if (bearerToken != null && bearerToken.startsWith(PREFIX)) {
            return bearerToken.substring(7); // Elimina el prefijo "Bearer " del token
        }
        return null;
    }

    // Valida el token JWT
    private boolean validateToken(String token) {
        try {
            extractClaims(token); // Si no lanza excepciones, el token es válido
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Extrae los claims (información del usuario) del token
    private Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}

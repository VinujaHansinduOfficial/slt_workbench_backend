package com.example.backend.config;



import com.example.backend.Util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor

public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private final JwtUtil jwtUtil;

    @Override

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.strip().startsWith("Bearer ")) {
            String token = authHeader.substring(7).strip();

            if (jwtUtil.validateToken(token)) {
                String email = jwtUtil.getEmailFromToken(token);
                String role = jwtUtil.getRoleFromToken(token);
                String name = jwtUtil.getNameFromToken(token); // Extract name from token

                System.out.println("JWT Email: " + email);
                System.out.println("JWT Role: " + role);
                System.out.println("JWT Name: " + name);

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                email, null, List.of(() -> "ROLE_" + role) // Ensure "ROLE_" prefix
                        );

                SecurityContextHolder.getContext().setAuthentication(authentication);
                request.setAttribute("userName", name);
            }
        }
        filterChain.doFilter(request, response);
    }

}

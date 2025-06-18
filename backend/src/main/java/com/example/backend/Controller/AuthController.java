package com.example.backend.Controller;


import com.example.backend.Dto.LoginRequest;
import com.example.backend.Dto.LoginResponse;
import com.example.backend.Sevice.AuthServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class AuthController {

    @Autowired
    private AuthServiceImpl authService;

    @PostMapping("/internal")
    public ResponseEntity<LoginResponse> loginInternal(@RequestBody Map<String, String> payload, HttpSession session) {
        String email = payload.get("email");
        LoginResponse response = authService.authenticateInternalUser(email, session);
        return ResponseEntity.ok(response);
    }
}


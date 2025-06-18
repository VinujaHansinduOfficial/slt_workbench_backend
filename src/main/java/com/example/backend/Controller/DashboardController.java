package com.example.backend.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping("/dashboard")
public class DashboardController {

    @GetMapping("/user")
    public ResponseEntity<String> getUserSessionInfo(HttpSession session) {
        String employeeNumber = (String) session.getAttribute("username");
        String email = (String) session.getAttribute("email");

        if (employeeNumber == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No active session");
        }

        return ResponseEntity.ok("Logged in as: " + employeeNumber + " (" + email + ")");
    }
}
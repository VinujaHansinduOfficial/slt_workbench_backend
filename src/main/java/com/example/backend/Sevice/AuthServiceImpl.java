package com.example.backend.Sevice;

import com.example.backend.Dto.LoginRequest;
import com.example.backend.Dto.LoginResponse;
import com.example.backend.Entity.User;
import com.example.backend.Repo.UserRepository;
import com.example.backend.Util.JwtUtil;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl {


    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public LoginResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());


        if (!loginRequest.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        // Generate token with role
        String token = jwtUtil.generateToken(user.getEmail(), user.getPriRole(), user.getName());

        return new LoginResponse(token,  user.getPriRole(), user.getName(),  "Login successful");
    }


    public String getUserName(String email) {
        User user = userRepository.findByEmail(email);
        return user.getName();
    }

    public LoginResponse authenticateInternalUser(String email, HttpSession session) {
        User user = userRepository.findByEmail(email);

            session.setAttribute("username", user.getName());
            String token = jwtUtil.generateToken(user.getEmail(), user.getPriRole(), user.getName());

            return new LoginResponse(token,  user.getPriRole(), user.getName(),  "Login successful");


    }




}

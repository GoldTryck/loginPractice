package com.daw.loginPractice.controllers;

import lombok.RequiredArgsConstructor;
import com.daw.loginPractice.dtos.request.LoginRequest;
import com.daw.loginPractice.dtos.response.LoginResponse;
import com.daw.loginPractice.services.AuthService;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}

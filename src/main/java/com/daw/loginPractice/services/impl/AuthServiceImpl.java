package com.daw.loginPractice.services.impl;


import com.daw.loginPractice.dtos.request.LoginRequest;
import com.daw.loginPractice.dtos.response.LoginResponse;
import com.daw.loginPractice.exceptions.AuthenticationException;
import com.daw.loginPractice.models.entities.Usuario;
import com.daw.loginPractice.repositories.UsuarioRepository;
import com.daw.loginPractice.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponse login(LoginRequest request) {
        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new AuthenticationException("Usuario no encontrado"));

        if (!passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
            throw new AuthenticationException("Contraseña incorrecta");
        }

        return new LoginResponse(usuario.getUsername(), usuario.getRole());
    }
}
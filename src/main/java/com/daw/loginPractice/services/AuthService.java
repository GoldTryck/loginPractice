package com.daw.loginPractice.services;

import com.daw.loginPractice.dtos.request.LoginRequest;
import com.daw.loginPractice.dtos.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest request);
}
package br.com.loudness.ecommerce.controllers;

import br.com.loudness.ecommerce.core.domain.dtos.auth.AuthenticationDTO;

import br.com.loudness.ecommerce.services.AuthService;
import br.com.loudness.ecommerce.services.AuthorizationService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid AuthenticationDTO data) {
       return authService.signin(data);
    }
}

package br.com.loudness.ecommerce.core.domain.dtos.auth;

import org.springframework.security.core.userdetails.UserDetails;

public record LoginResponseDTO(String token, UserDetails collaborator) {

}

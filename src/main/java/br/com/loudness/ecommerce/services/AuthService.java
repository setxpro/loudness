package br.com.loudness.ecommerce.services;

import br.com.loudness.ecommerce.core.cases.ServiceMessage;
import br.com.loudness.ecommerce.core.domain.dtos.auth.AuthenticationDTO;
import br.com.loudness.ecommerce.core.domain.dtos.auth.LoginResponseDTO;
import br.com.loudness.ecommerce.core.domain.entities.Collaborator;
import br.com.loudness.ecommerce.core.domain.repositories.CollaboratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    CollaboratorRepository collaboratorRepository;

    @Autowired
    TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public ResponseEntity<Object> signin(AuthenticationDTO data) {
        UserDetails collaborator = collaboratorRepository.findByLogin(data.login());

        if(collaborator == null) {
            return ResponseEntity.status(400).body(new ServiceMessage("Usuário não encontrado!"));
        }
        var usernamePass = new UsernamePasswordAuthenticationToken(data.login(), data.password());

        var auth = this.authenticationManager.authenticate(usernamePass);
        var token = tokenService.generateToken((Collaborator) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token, collaborator));
    }
}

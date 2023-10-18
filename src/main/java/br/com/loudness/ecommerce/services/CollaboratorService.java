package br.com.loudness.ecommerce.services;

import br.com.loudness.ecommerce.core.domain.dtos.collaborator.CollaboratorDto;
import br.com.loudness.ecommerce.core.domain.entities.Collaborator;
import br.com.loudness.ecommerce.core.domain.repositories.CollaboratorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CollaboratorService {

    private final CollaboratorRepository collaboratorRepository;

    public CollaboratorService(CollaboratorRepository collaboratorRepository) {
        this.collaboratorRepository = collaboratorRepository;
    }

    public ResponseEntity<Object> saveCollaborator(CollaboratorDto collaboratorDto) {

        if(this.collaboratorRepository.findByLogin(collaboratorDto.login()) != null) return ResponseEntity.badRequest().body("Usuário já cadastrado para o login");

        String encryptedPassword = new BCryptPasswordEncoder().encode(collaboratorDto.password());

        UUID uuid = UUID.randomUUID();

        Collaborator collaborator = new Collaborator(collaboratorDto);

        collaborator.setPassword(encryptedPassword);
        collaborator.setCollaboratorId(uuid);

        this.collaboratorRepository.save(collaborator);

        return ResponseEntity.status(201).body("Collaborator created with successfully");

    }
}

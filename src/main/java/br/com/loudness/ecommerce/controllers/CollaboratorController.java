package br.com.loudness.ecommerce.controllers;

import br.com.loudness.ecommerce.core.domain.dtos.collaborator.CollaboratorDto;
import br.com.loudness.ecommerce.services.CollaboratorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/collaborator")
public class CollaboratorController {
    private final CollaboratorService collaboratorService;

    public CollaboratorController(CollaboratorService collaboratorService) {
        this.collaboratorService = collaboratorService;
    }

    @PostMapping
    public ResponseEntity<Object> createCollaborator(@RequestBody @Valid CollaboratorDto collaboratorDto) {
        return collaboratorService.saveCollaborator(collaboratorDto);
    }
}

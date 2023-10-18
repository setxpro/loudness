package br.com.loudness.ecommerce.core.domain.dtos.collaborator;

import br.com.loudness.ecommerce.core.domain.enums.GenderEnum;
import br.com.loudness.ecommerce.core.domain.enums.UserRole;

import java.time.LocalDateTime;
import java.util.UUID;

public record CollaboratorDto(
        UUID collaboratorId,
        String name,
        String middlename,
        String email,
        String login,
        String password,
        String phonenumber,
        LocalDateTime dateOfBith,
        LocalDateTime admissionDate,
        LocalDateTime endDate,
        UserRole role,
        GenderEnum gender
) {
}

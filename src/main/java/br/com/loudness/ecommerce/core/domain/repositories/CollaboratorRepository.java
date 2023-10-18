package br.com.loudness.ecommerce.core.domain.repositories;

import br.com.loudness.ecommerce.core.domain.entities.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface CollaboratorRepository extends JpaRepository<Collaborator, UUID> {
    UserDetails findByLogin(String login);
}

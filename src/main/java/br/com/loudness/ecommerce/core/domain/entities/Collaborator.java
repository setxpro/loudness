package br.com.loudness.ecommerce.core.domain.entities;

import br.com.loudness.ecommerce.core.domain.dtos.collaborator.CollaboratorDto;
import br.com.loudness.ecommerce.core.domain.enums.GenderEnum;
import br.com.loudness.ecommerce.core.domain.enums.UserRole;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity(name="collaborator")
@Getter
@Setter
@Table(name="collaborator")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="collaboratorId")
public class Collaborator implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID collaboratorId;
    private String name;
    private String middlename;
    @Email
    @Schema(example = "email@email.com.br")
    private String email;
    private String login;
    private String password;
    private String phonenumber;
    private LocalDateTime dateOfBith;
    private LocalDateTime admissionDate;
    private LocalDateTime endDate;
    private UserRole role;
    private GenderEnum gender;

    public Collaborator(CollaboratorDto collaborator) {
        this.collaboratorId = collaborator.collaboratorId();
        this.name = collaborator.name();
        this.middlename = collaborator.middlename();
        this.email = collaborator.email();
        this.login = collaborator.login();
        this.password = collaborator.password();
        this.phonenumber = collaborator.phonenumber();
        this.dateOfBith = collaborator.dateOfBith();
        this.admissionDate = collaborator.admissionDate();
        this.endDate = collaborator.endDate();
        this.role = collaborator.role();
        this.gender = collaborator.gender();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

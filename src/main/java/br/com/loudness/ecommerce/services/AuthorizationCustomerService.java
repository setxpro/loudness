package br.com.loudness.ecommerce.services;

import br.com.loudness.ecommerce.core.domain.repositories.CollaboratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationCustomerService implements UserDetailsService {

    @Autowired
    CollaboratorRepository collaboratorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return collaboratorRepository.findByLogin(username);
    }
}

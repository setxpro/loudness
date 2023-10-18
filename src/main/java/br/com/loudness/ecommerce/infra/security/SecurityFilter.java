package br.com.loudness.ecommerce.infra.security;

import br.com.loudness.ecommerce.core.domain.dtos.messages.ErrorDto;
import br.com.loudness.ecommerce.core.domain.repositories.CollaboratorRepository;
import br.com.loudness.ecommerce.services.TokenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    TokenService tokenService;

    @Autowired
    CollaboratorRepository collaboratorRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);

        // have token
        if(token != null) {
            // Validation
            var login = tokenService.validateToken(token);
            UserDetails user = collaboratorRepository.findByLogin(login);

            // verifications of the user
            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

            // Save token in context
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            ErrorDto error = new ErrorDto(401, "Access denied");

            response.setStatus(error.getStatus());
            response.setContentType("application/json");
            ObjectMapper mapper = new ObjectMapper();

            response.getWriter().print(mapper.writeValueAsString(error));
            response.getWriter().flush();
            return;
        }

        // token is null ?  next filter
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if(authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }
}

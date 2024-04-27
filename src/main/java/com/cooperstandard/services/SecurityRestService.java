package com.cooperstandard.services;

import com.cooperstandard.model.ModelUsuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import java.util.Optional;

public class SecurityRestService extends AbstractRestService {

    public Optional<ModelUsuario> authentication(final String username, final String password) {
        try {
            final ModelUsuario modelUsuario = new ModelUsuario(username, password);
            final ResponseEntity<ModelUsuario> response = restTemplate.postForEntity(
                    String.format("%s/security/authentication", BASE_URL),
                    modelUsuario,
                    ModelUsuario.class
            );
            if (response.getStatusCode() == HttpStatus.OK && response.hasBody()) {
                return Optional.of(response.getBody());
            }
        } catch (RestClientException restClientException) {
            logger.severe("Invalid username or password");
        }
        return Optional.empty();
    }
}

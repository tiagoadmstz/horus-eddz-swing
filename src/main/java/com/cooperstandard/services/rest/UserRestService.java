package com.cooperstandard.services.rest;

import com.cooperstandard.model.ModelSessaoUsuario;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class UserRestService extends AbstractRestService {

    public String findLineByUser() {
        final ResponseEntity<String> response = restTemplate.getForEntity(
                String.format("%s/user/line/{1}", BASE_URL),
                String.class,
                ModelSessaoUsuario.nome
        );
        return response.getBody();
    }

    public List<String> findPermissionsByUser() {
        final ResponseEntity<List<String>> response = restTemplate.exchange(
                String.format("%s/user/permissions/{1}", BASE_URL),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() {
                },
                ModelSessaoUsuario.codigo
        );
        return response.getBody();
    }
}

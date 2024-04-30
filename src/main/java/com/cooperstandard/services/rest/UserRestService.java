package com.cooperstandard.services.rest;

import com.cooperstandard.model.ModelPermissaousuario;
import com.cooperstandard.model.ModelSessaoUsuario;
import com.cooperstandard.model.ModelUsuario;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class UserRestService extends AbstractRestService {

    public ModelUsuario saveUser(ModelUsuario userDto) {
        final ResponseEntity<ModelUsuario> response = restTemplate.postForEntity(
                String.format("%s/user/save", BASE_URL),
                userDto,
                ModelUsuario.class
        );
        return response.getBody();
    }

    public void deleteUser(int userId) {
        restTemplate.delete(String.format("%s/user/delete/{id}", BASE_URL), userId);
    }

    public String findLineByUser() {
        final ResponseEntity<String> response = restTemplate.getForEntity(
                String.format("%s/user/line/{1}", BASE_URL),
                String.class,
                ModelSessaoUsuario.nome
        );
        return response.getBody();
    }

    public List<ModelUsuario> findAll() {
        final ResponseEntity<List<ModelUsuario>> response = restTemplate.exchange(
                String.format("%s/user/list", BASE_URL),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ModelUsuario>>() {
                }
        );
        return response.getBody();
    }

    public ModelUsuario findUserById(int userId) {
        final ResponseEntity<ModelUsuario> response = restTemplate.getForEntity(
                String.format("%s/user/{1}", BASE_URL),
                ModelUsuario.class,
                userId
        );
        return response.getBody();
    }

    public void savePermissions(List<ModelPermissaousuario> permissionDtoList) {
        restTemplate.postForEntity(
                String.format("%s/user/permissions/saveAll", BASE_URL),
                permissionDtoList,
                ModelPermissaousuario.class
        );
    }

    public void deletePermissionByUserId(int userId) {
        restTemplate.delete(String.format("%s/user/permissions/delete/{id}", BASE_URL), userId);
    }

    public List<String> findPermissionsByUser() {
        return findPermissionsByUserId(ModelSessaoUsuario.codigo);
    }

    public List<String> findPermissionsByUserId(int userId) {
        final ResponseEntity<List<String>> response = restTemplate.exchange(
                String.format("%s/user/permissions/{1}", BASE_URL),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() {
                },
                userId
        );
        return response.getBody();
    }
}

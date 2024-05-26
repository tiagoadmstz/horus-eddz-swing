package com.cooperstandard.services.rest;

import com.cooperstandard.model.ModelMontadora;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class AssemblerRestService extends AbstractRestService {

    public List<ModelMontadora> list() {
        final ResponseEntity<List<ModelMontadora>> response = restTemplate.exchange(
                String.format("%s/assembler/list", BASE_URL),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ModelMontadora>>() {
                }
        );
        return response.getBody();
    }

    public ModelMontadora save(final ModelMontadora assemblerDto) {
        final ResponseEntity<ModelMontadora> response = restTemplate.postForEntity(
                String.format("%s/assembler/save", BASE_URL),
                assemblerDto,
                ModelMontadora.class
        );
        return response.getBody();
    }

    public boolean delete(final int id) {
        restTemplate.delete(String.format("%s/assembler/delete/{id}", BASE_URL), id);
        return true;
    }

    public ModelMontadora findById(final int id) {
        final ResponseEntity<ModelMontadora> response = restTemplate.getForEntity(
                String.format("%s/assembler/{id}", BASE_URL), ModelMontadora.class, id
        );
        return response.getBody();
    }
}

package com.cooperstandard.services.rest;

import com.cooperstandard.model.ModelMontadora;
import org.springframework.http.ResponseEntity;

public class AssemblerRestService extends AbstractRestService {

    public ModelMontadora save(final ModelMontadora assemblerDto) {
        final ResponseEntity<ModelMontadora> response = restTemplate.postForEntity(
                String.format("%s/assembler/save", BASE_URL),
                assemblerDto,
                ModelMontadora.class
        );
        return response.getBody();
    }
}

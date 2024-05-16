package com.cooperstandard.services;

import com.cooperstandard.model.ModelMontadora;
import com.cooperstandard.services.rest.AssemblerRestService;

import java.util.List;
import java.util.Objects;

public class AssemblerService {

    private final AssemblerRestService assemblerRestService;

    public AssemblerService() {
        this.assemblerRestService = new AssemblerRestService();
    }

    public boolean save(ModelMontadora modelMontadora) {
        final ModelMontadora saved = assemblerRestService.save(modelMontadora);
        return Objects.nonNull(saved.getId());
    }

    public boolean excluirMontadoraController(int codigo) {
        return false;
    }

    public ModelMontadora getMontadoraController(int codigo) {
        return null;
    }

    public boolean atualizarMontadoraController(ModelMontadora modelMontadora) {
        return false;
    }

    public List<ModelMontadora> getListaMontadoraController() {
        return null;
    }
}

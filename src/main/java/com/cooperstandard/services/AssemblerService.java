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

    public List<ModelMontadora> list() {
        return assemblerRestService.list();
    }

    public boolean save(final ModelMontadora modelMontadora) {
        final ModelMontadora saved = assemblerRestService.save(modelMontadora);
        return Objects.nonNull(saved.getId());
    }

    public boolean excluirMontadoraController(final int codigo) {
        return assemblerRestService.delete(codigo);
    }

    public ModelMontadora getMontadoraController(final int codigo) {
        return assemblerRestService.findById(codigo);
    }

    public boolean atualizarMontadoraController(final ModelMontadora modelMontadora) {
        return save(modelMontadora);
    }

    public List<ModelMontadora> getListaMontadoraController() {
        return assemblerRestService.list();
    }
}
